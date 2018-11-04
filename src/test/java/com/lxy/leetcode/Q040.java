package com.lxy.leetcode;

import java.util.*;

/**
 * Created by lixiangyu on 2018/11/4.
 */
public class Q040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        solve(result, list, candidates, target, 0, 0);
        return new ArrayList<>(result);
    }

    private void solve(Set<List<Integer>> result, List<Integer> list, int[] candidates, int target, int curr, int index) {
        if (curr >= target) {
            if (curr == target) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            list.add(candidates[i]);
            solve(result, list, candidates, target, curr + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
