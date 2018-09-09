package com.lxy.leetcode;

/**
 * 读题费劲，其实没什么东西
 *
 * Created by lixiangyu on 2018/9/9.
 */
public class Q413 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int ret = 0;
        int cnt = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cnt ++;
                ret += cnt;
            } else {
                cnt = 0;
            }
        }
        return ret;

    }
}
