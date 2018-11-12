package com.lxy.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by lixiangyu on 2018/11/12.
 */
public class Q049 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] c = new int[26];
            for(int i = 0 ; i < str.length();i++) {
                int ch = str.charAt(i) - 'a';
                c[ch] ++;
            }
            String key = Arrays.toString(c);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
