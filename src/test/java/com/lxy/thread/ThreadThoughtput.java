package com.lxy.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池吞吐量测试
 *
 * 1000任务，每个任务5ms，
 *
 * 1  5876
 * 2  2923
 * 4  1454
 * 8  712
 * 10 590
 * 16 385
 * 32 202
 * 48 189
 * 64 187
 *
 * 测试的机器为MacBookPro，四核八线程处理器
 * 大致可以看作是线程核心数等于CPU核心数的时候能够最大利用CPU性能，或线程核心数
 *
 * <p>
 * Created by lixiangyu on 2018/9/15.
 */
public class ThreadThoughtput {

    private static int threadcount = 1000;
    private static volatile CountDownLatch latch = new CountDownLatch(threadcount);

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger cnt = new AtomicInteger(0);

        int corePoolSize = 10;
        int maximumPoolSize = corePoolSize;
        long keepAliveTime = 10L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize
                , keepAliveTime, unit, workQueue);

        long start = System.currentTimeMillis();

        while(true) {
            int index = cnt.addAndGet(1);
            if(index > threadcount) {
                break;
            }
            // System.out.println(index);
            WorkThread workThread = new WorkThread();
            poolExecutor.submit(workThread);
        }
        latch.await();
        long cost = System.currentTimeMillis() - start;
        System.out.println(cost);
        System.out.println("finished.");
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

