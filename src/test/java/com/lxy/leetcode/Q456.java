package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/9/14.
 */
public class Q456 {

    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 0};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        for (int i = 1; i <= nums.length - 2; i++) {
            int minLeft = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (minLeft > nums[j]) {
                    minLeft = nums[j];
                }
            }
            if (minLeft >= nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (minLeft < nums[j] && nums[j] < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
