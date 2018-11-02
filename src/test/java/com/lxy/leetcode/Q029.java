package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/2.
 */
public class Q029 {

    public static void main(String[] args) {
        Q029 q029 = new Q029();
        System.out.println(q029.divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        System.out.println((long) dividend / (long) divisor);
        long result = (long) dividend / (long) divisor;
        int r = (int) result;
        if (result > Integer.MAX_VALUE) {
            r = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            r = Integer.MIN_VALUE;
        }
        return r;
    }
}
