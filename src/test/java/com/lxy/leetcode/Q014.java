package com.lxy.leetcode;

import sun.jvm.hotspot.oops.BranchData;

/**
 * Created by lixiangyu on 2018/10/8.
 */
public class Q014 {


    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        if (1 == strs.length) {
            return strs[0];
        }

        String prefix = "";
        int loopNum = 0;
        while (true) {
            char tmp = '0';
            boolean same = true;
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (loopNum >= str.length()) {
                    same = false;
                    break;
                }
                if (i == 0) {
                    tmp = str.charAt(loopNum);
                } else if (str.charAt(loopNum) != tmp) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
            prefix += tmp;
            loopNum++;
        }
        return prefix;
    }
}
