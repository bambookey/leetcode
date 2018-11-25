package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/25.
 */
public class Q066 {
    public int[] plusOne(int[] digits) {
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
        for (int i = 0; i < digits.length; i++) {
            arr[i + 1] = digits[i];
        }
        return arr;
    }
}
