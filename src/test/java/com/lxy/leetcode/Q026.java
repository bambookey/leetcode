package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/10/28.
 */
public class Q026 {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int p = 0;
        int pre = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                res++;
                nums[p] = nums[i];
                p++;
            }
        }
        return res;
    }
}
