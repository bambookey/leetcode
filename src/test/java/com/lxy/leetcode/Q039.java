package com.lxy.leetcode;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最简单的回溯法
 * <p>
 * Created by lixiangyu on 2018/11/4.
 */
public class Q039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(result, list, candidates, target, 0, 0);
        return result;
    }

    private void solve(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int curr, int index) {
        if (curr >= target) {
            if (target == curr) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            solve(result, list, candidates, target, curr + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

}
