package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/13.
 */
public class Q053 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 0;
        for(int n : nums) {
            max += n;
            if(max > result) {
                result = max;
            }
            if(max <= 0) {
                max = 0;
            }
        }
        return result;
    }
}
