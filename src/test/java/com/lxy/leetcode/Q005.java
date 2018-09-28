package com.lxy.leetcode;

/**
 * 求回文串
 * 代码写的难看死了
 *
 * Created by lixiangyu on 2018/9/28.
 */
public class Q005 {
    public static void main(String[] args) {
        Q005 q005 = new Q005();
        System.out.println("result:" + q005.longestPalindrome(""));
    }

    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }
        String result = s.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {
            if (getAns(s, i).length() > result.length()) {
                result = getAns(s, i);
            }
            if (getAns2(s, i).length() > result.length()) {
                result = getAns2(s, i);
            }
        }
        return result;
    }

    private String getAns(String s, int index) {
        int pace = 0;
        while (index + pace < s.length() && index - pace >= 0) {
            if (s.charAt(index + pace) != s.charAt(index - pace)) {
                break;
            }
            pace++;
        }
        return s.substring(index - pace + 1, index + pace);
    }

    private String getAns2(String s, int index) {
        int pace = 0;
        while (index + pace + 1 < s.length() && index - pace >= 0) {
            if (s.charAt(index + pace + 1) != s.charAt(index - pace)) {
                break;
            }
            pace++;
        }
        return s.substring(index - pace + 1, index + pace + 1);
    }
}
