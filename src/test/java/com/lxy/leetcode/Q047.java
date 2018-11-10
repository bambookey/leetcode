package com.lxy.leetcode;

import java.util.*;

/**
 * Created by lixiangyu on 2018/11/10.
 */
public class Q047 {

    public static void main(String[] args) {
        Q047 q047 = new Q047();
        int[] arr = {1, 1, 2};
        List<List<Integer>> list = q047.permuteUnique(arr);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        Arrays.sort(nums);
        solve(sets, new ArrayList<Integer>(), new HashSet<Integer>(), nums);
        return sets;
    }

    private void solve(List<List<Integer>> sets, List<Integer> set, Set<Integer> visited, int[] nums) {
        if (set.size() == nums.length) {
            sets.add(new ArrayList<Integer>(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            // 去重的思想主要在这里体现，比使用set去重优雅很多，不过注意要先排序
            if (i > 0 && nums[i - 1] == nums[i] && visited.contains(i - 1)) {
                continue;
            }
            set.add(nums[i]);
            visited.add(i);
            solve(sets, set, visited, nums);
            set.remove(set.size() - 1);
            visited.remove(i);
        }
    }
}
