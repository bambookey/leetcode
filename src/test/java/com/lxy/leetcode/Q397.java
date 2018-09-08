package com.lxy.leetcode;

/**
 * 一个小坑，有个input为 Integer.MAX_VALUE
 * +1 的时候会导致溢出
 * 别的没什么了，典型的递归题目
 * <p>
 * Created by lixiangyu on 2018/9/8.
 */
public class Q397 {
    public static void main(String[] args) {
        //System.out.println(2147483647 + 1);
        System.out.println(integerReplacement(2147483647));
    }

    public static int integerReplacement(long n) {
        return solve(n, 0);

    }

    private static int solve(long num, int pace) {
        if (num == 1) {
            return pace;
        }
        if (num == 2) {
            return pace + 1;
        }
        if (num % 2 == 0) {
            return solve(num / 2, pace + 1);
        } else {
            return Math.min(solve(num + 1, pace + 1), solve(num - 1, pace + 1));
        }
    }
}
