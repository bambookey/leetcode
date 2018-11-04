package com.lxy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lixiangyu on 2018/11/4.
 */
public class Q038 {

    public static void main(String[] args) {
        Q038 q038 = new Q038();
        System.out.println(q038.expand("21"));
    }

    static List<String> result = new LinkedList<>();

    static {
        result.add("1");
        String expand = "1";
        for (int i = 1; i < 30; i++) {
            expand = expand(expand);
            result.add(expand);
        }
    }

    public String countAndSay(int n) {
        return result.get(n - 1);
    }

    private static String expand(String num) {
        StringBuilder expand = new StringBuilder();
        int cnt = 1;
        int n = num.charAt(0) - '0';
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) - '0' != n) {
                expand.append(cnt).append(n);
                cnt = 1;
                n = num.charAt(i) - '0';
            } else {
                cnt++;
            }
        }
        if (cnt != 0) {
            expand.append(cnt).append(n);
        }
        return expand.toString();
    }
}
