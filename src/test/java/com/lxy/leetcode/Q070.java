package com.lxy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixiangyu on 2018/11/13.
 */
public class Q070 {

    Map<Integer, Integer> m = new HashMap<>();

    public int climbStairs(int n) {
        if(m.containsKey(n)) {
            return m.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = climbStairs(n - 1);
        m.put(n - 1, n1);
        int n2 = climbStairs(n - 2);
        m.put(n - 2, n2);
        return n1 + n2;
    }
}
