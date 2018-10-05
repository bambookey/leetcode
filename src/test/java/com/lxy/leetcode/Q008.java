package com.lxy.leetcode;

/**
 * 1. 字符串空格分割
 * 2. 前缀正负号（考虑同时存在的情形）
 * 3. 越界
 * <p>
 * Created by lixiangyu on 2018/10/5.
 */
public class Q008 {
    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-+1"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        str = str.split(" ")[0];

        int k = 1;
        long result = 0;
        if (str.startsWith("-")) {
            str = str.substring(1);
            k = -1;
        } else if (str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.length() == 0) {
            return 0;
        }


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }
            result = result * 10 + (c - '0');
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                if (k < 0) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return (int) result * k;
    }
}
