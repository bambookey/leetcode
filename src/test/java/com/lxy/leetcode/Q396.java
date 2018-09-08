package com.lxy.leetcode;

/**
 * 画一画就看出来了
 * 固定数组，不一定系数的时候可以整体观察，找到解决方法
 * <p>
 * Created by lixiangyu on 2018/9/8.
 */
public class Q396 {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(A));
    }

    public static int maxRotateFunction(int[] A) {
        int len = A.length;
        int max = 0;
        int loopSum = 0;
        for (int i = 0; i < len; i++) {
            max += A[i] * i;
            loopSum += A[i];
        }

        int loopSize = max;
        for (int i = 0; i < len - 1; i++) {
            int tmp = loopSize;
            tmp += loopSum;
            tmp -= len * A[len - 1 - i];
            loopSize = tmp;
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
