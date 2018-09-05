package com.lxy.leetcode;

/**
 * 分治思想
 *
 * Created by lixiangyu on 2018/9/5.
 */
public class Q395 {
    public static void main(String[] args) {
        System.out.println(longestSubstring("bbaaacbd", 3));
    }

    public static int longestSubstring(String s, int k) {
        return solve(s, k, 0, s.length() - 1);
    }

    private static int solve(String s, int k, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int[] cnt = new int[26];
        for (int i = start; i <= end; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0 && cnt[i] < k) {
                int p = s.indexOf((char) (i + 'a'), start);
                return Math.max(solve(s, k, start, p - 1), solve(s, k, p + 1, end));
            }
        }
        return end - start + 1;
    }

}
