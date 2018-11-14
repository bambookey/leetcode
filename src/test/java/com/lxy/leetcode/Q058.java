package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/14.
 */
public class Q058 {
    public int lengthOfLastWord(String s) {
        return s.trim().split(" ")[s.trim().split(" ").length - 1].length();
    }
}
