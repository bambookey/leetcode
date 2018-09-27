package com.lxy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 是要找出最长的不重复字串，能看出是个递归分治思想
 * <p>
 * 最开始这里错了
 * Math.max(i - start, solve(s, index, end));
 * Math.max(i - start, solve(s, start + 1, end));
 * 写的很快，但是没能一次AC
 * <p>
 * Created by lixiangyu on 2018/9/27.
 */
public class Q003 {

    public static void main(String[] args) {
        Q003 q003 = new Q003();
        System.out.println(q003.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        return solve(s, 0, s.length());
    }

    public int solve(String s, int start, int end) {
        Set<Character> visited = new HashSet<>();
        int i = start;
        for (; i < end; i++) {
            if (visited.contains(s.charAt(i))) {
                return Math.max(i - start, solve(s, start + 1, end));
            }
            visited.add(s.charAt(i));
        }
        return end - start;
    }
}
