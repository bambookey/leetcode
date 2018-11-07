package com.lxy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiangyu on 2018/11/5.
 */
public class Q046 {
    List<List<Integer>> result;
    public static void main(String[] args) {
        Q046 q046 = new Q046();
        int[] arr = {1,2,3};
        q046.permute(arr);
        System.out.println(q046.result);
    }



    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        solve(new ArrayList<Integer>(), nums);
        return result;
    }

    private void solve(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            solve(list, nums);
            list.remove(list.size() - 1);
        }
    }
}
