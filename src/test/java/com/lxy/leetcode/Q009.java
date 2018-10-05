package com.lxy.leetcode;

/**
 * 没什么难度，一次AC
 *
 * Created by lixiangyu on 2018/10/5.
 */
public class Q009 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
