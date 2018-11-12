package com.lxy.leetcode;

/**
 * 考虑到int min的取值范围，不能直接对负数取正
 *
 * Created by lixiangyu on 2018/11/12.
 */
public class Q050 {
    public double myPow(double x, int n) {

        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        double half = myPow(x, n / 2);
        double ret = half * half;
        if (n % 2 != 0) {
            if(n > 0) {
                ret *= x;
            } else {
                ret /= x ;
            }
        }
        return ret;
    }
}
