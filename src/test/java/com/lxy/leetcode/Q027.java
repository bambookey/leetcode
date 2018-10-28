package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/10/28.
 */
public class Q027 {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                cnt++;
            } else {
                nums[p] = nums[i];
                p++;
            }
        }
        return nums.length - cnt;
    }
}
