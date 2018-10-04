package com.lxy.leetcode;

/**
 * 没有一次AC
 * 需要细心的
 * 其实也是没有读题，注意返回结果规定的范围，这在开发项目中，也是一样重要的
 *
 * Created by lixiangyu on 2018/10/4.
 */
public class Q007 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long result = 0;
        long cp = x;

        while (cp != 0) {
            long k = cp % 10;
            result = result * 10 + k;
            cp /= 10;
        }
        if (x < 0) {
            result = Math.abs(result) * -1;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }
}
