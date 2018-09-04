package com.lxy.leetcode;

import sun.jvm.hotspot.oops.BranchData;

/**
 * Created by lixiangyu on 2018/9/3.
 */
public class Q392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen > tlen) {
            return false;
        }

        int ps = 0;
        int pt = 0;
        int found = 0;
        for (; ps < slen; ps++) {
            char cs = s.charAt(ps);
            for (; pt < tlen; pt++) {
                char ct = t.charAt(pt);
                if (cs == ct) {
                    found++;
                    pt++;
                    break;
                }
            }
        }
        if (found == slen) {
            return true;
        }
        return false;
    }
}
