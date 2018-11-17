package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/17.
 */
public class Q055 {
    public static void main(String[] args) {
        Q055 q055 = new Q055();
        int[] arr = {2, 0, 0};
        System.out.println(q055.canJump(arr));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        int i = 0;
        for (; i < nums.length && i <= max; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return i == nums.length;
    }
}
