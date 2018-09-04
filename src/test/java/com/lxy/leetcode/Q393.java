package com.lxy.leetcode;

/**
 * 这种题竟然还需要debug，真是。。。
 * 最开始的时候想了位运算，但其实就是二进制转化为整数的数值范围
 * 复杂的逻辑判断注意程序的每一个逻辑环节都要有出口才对
 *
 * Created by lixiangyu on 2018/9/4.
 */
public class Q393 {

    public static void main(String[] args) {
        int[] data = {235, 140, 4};
        System.out.println(validUtf8(data));
        //System.out.println(235&192);
    }

    public static boolean validUtf8(int[] data) {

        int p = 0;
        for (; p < data.length; p++) {
            int d = data[p];
            if (d >= 0 && d <= 127) {
                continue;
            }
            if (d >= 240 && d <= 247) {
                for (int i = 0; i < 3; i++) {
                    p++;
                    if (p >= data.length) {
                        return false;
                    }
                    d = data[p];
                    if (d < 128 || d > 191) {
                        return false;
                    }
                }
                continue;
            }

            if (d >= 224 && d <= 239) {
                for (int i = 0; i < 2; i++) {
                    p++;
                    if (p >= data.length) {
                        return false;
                    }
                    d = data[p];
                    if (d < 128 || d > 191) {
                        return false;
                    }
                }
                continue;
            }

            if (d >= 192 && d <= 223) {
                for (int i = 0; i < 1; i++) {
                    p++;
                    if (p >= data.length) {
                        return false;
                    }
                    d = data[p];
                    if (d < 128 || d > 191) {
                        return false;
                    }
                }
                continue;
            }
            return false;
        }
        return true;
    }
}
