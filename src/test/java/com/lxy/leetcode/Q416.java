package com.lxy.leetcode;

import java.util.Arrays;

/**
 * 要点：
 * 1。过半剪枝
 * 2。从大到小的排序
 * 3。深度搜索在合理剪枝情况下还可以的
 *
 * Created by lixiangyu on 2018/9/9.
 */
public class Q416 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        int[] n = new int[nums.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = nums[n.length - 1 - i];
        }
        return solve(n, 0, 0, 0, total);

    }

    private static boolean solve(int[] nums, int index, int a, int b, int total) {
        if (a > total / 2 || b > total / 2) {
            return false;
        }
        if (index == nums.length - 1) {
            if (Math.abs(a - b) == nums[index]) {
                return true;
            } else {
                return false;
            }
        }
        return solve(nums, index + 1, a + nums[index], b, total)
                || solve(nums, index + 1, a, b + nums[index], total);
    }
}
