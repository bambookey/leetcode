package com.lxy.leetcode;

import java.util.Arrays;

/**
 * Created by lixiangyu on 2018/11/25.
 */
public class Q066 {
    /**
     * 大神的代码
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] out = new int[len + 1];
        Arrays.fill(out, 0);
        out[0] = 1;
        return out;
    }

    public int[] plusOne2(int[] digits) {
        int add = 0;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + add;
            if (val >= 10) {
                digits[i] = val % 10;
                add = 1;
            } else {
                digits[i] = val;
                return digits;
            }
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }
}
