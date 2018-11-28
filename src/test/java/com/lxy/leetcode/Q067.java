package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/28.
 */
public class Q067 {
    public static void main(String[] args) {
        Q067 q067 = new Q067();
        System.out.println(q067.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        String result = "";
        int add = 0;
        for (int i = 0; i < len; i++) {
            int indexA = a.length() - 1 - i;
            int indexB = b.length() - 1 - i;

            char ca = indexA >= 0 ? a.charAt(indexA) : '0';
            char cb = indexB >= 0 ? b.charAt(indexB) : '0';

            int r = add + ca + cb - '0' - '0';
            add = r >= 2 ? 1 : 0;
            result = (r == 2 || r == 0 ? "0" : "1") + result;
        }
        if (add == 1) {
            result = "1" + result;
        }
        return result;
    }
}
