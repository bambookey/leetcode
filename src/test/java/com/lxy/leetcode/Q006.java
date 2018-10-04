package com.lxy.leetcode;

/**
 * 题目不难，不过需要冷静分析
 * 需要考虑边界处理
 *
 * Created by lixiangyu on 2018/10/4.
 */
public class Q006 {
    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                while (j < len) {
                    result.append(s.charAt(j));
                    j += (numRows - 1) * 2;
                }
            } else {
                int j = i;
                int step1 = (numRows - 1 - i) * 2;
                int step2 = i * 2;
                boolean change = true;
                while (j < len) {
                    if (change) {
                        result.append(s.charAt(j));
                        j += step1;
                    } else {
                        result.append(s.charAt(j));
                        j += step2;
                    }
                    change = !change;
                }
            }
        }
        return result.toString();
    }
}
