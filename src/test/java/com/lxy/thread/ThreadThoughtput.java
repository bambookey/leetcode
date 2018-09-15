package com.lxy.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池吞吐量测试
 * <p>
 * 1000任务，每个任务5ms，
 * <p>
 * 1  5876
 * 2  2923
 * 4  1454
 * 8  712
 * 10 590
 * 16 385
 * 32 202
 * 48 189
 * 64 187
 * <p>
 * 测试的机器为MacBookPro，四核八线程处理器
 * 大致可以看作是线程核心数等于CPU核心数的时候能够最大利用CPU性能，或线程核心数+1
 * <p>
 * 实际上，日志收集中的处理策略，本质上是通过将请求根据id分散到了多个（单线程+缓冲队列）组合
 * 以实现增大了吞吐量的目的
 * <p>
 * 跑了一次两种功能线程池的对比：前面的是并发线程池
 * 可以发现二者性能几乎无差别
 * i=1
 * 5693
 * 5951
 * i=2
 * 2914
 * 2977
 * i=4
 * 1486
 * 1476
 * i=8
 * 729
 * 716
 * i=16
 * 385
 * 379
 * i=32
 * 194
 * 188
 * i=64
 * 100
 * 101
 * <p>
 * <p>
 * Created by lixiangyu on 2018/9/15.
 */
public class ThreadThoughtput {

    private static int threadcount = 1000;
    private static volatile CountDownLatch latch;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 64; i *= 2) {
            System.out.println("i=" + i);
            testThreadPool(i);
            testParallelThreadPool(i);
        }
    }

    public static void testParallelThreadPool(int poolSize) throws InterruptedException {
        Map<Integer, ExecutorService> map = new HashMap<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            map.put(i, Executors.newFixedThreadPool(1));
        }
        latch = new CountDownLatch(threadcount);
        AtomicInteger cnt = new AtomicInteger(0);

        long start = System.currentTimeMillis();
        while (true) {
            int index = cnt.addAndGet(1);
            if (index > threadcount) {
                break;
            }
            WorkThread workThread = new WorkThread();
            map.get(index % poolSize).submit(workThread);
        }
        latch.await();
        long cost = System.currentTimeMillis() - start;
        System.out.println(cost);


    }


    public static void testThreadPool(int poolSize) throws InterruptedException {

        latch = new CountDownLatch(threadcount);
        AtomicInteger cnt = new AtomicInteger(0);

        int corePoolSize = poolSize;
        int maximumPoolSize = corePoolSize;
        long keepAliveTime = 10L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize
                , keepAliveTime, unit, workQueue);

        long start = System.currentTimeMillis();

        while (true) {
            int index = cnt.addAndGet(1);
            if (index > threadcount) {
                break;
            }
            // System.out.println(index);
            WorkThread workThread = new WorkThread();
            poolExecutor.submit(workThread);
        }
        latch.await();
        long cost = System.currentTimeMillis() - start;
        System.out.println(cost);
    }

    static class WorkThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5L);
                // System.out.println("latch:" + latch.getCount());
                latch.countDown();
            } catch (Exception e) {

            }
        }
    }

}

