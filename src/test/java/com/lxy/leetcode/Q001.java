package com.lxy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixiangyu on 2018/9/17.
 */
public class Q001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int max = -1;
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if(i == map.get(target - nums[i])) {
                    continue;
                }
                max = Math.max(i, map.get(target - nums[i]));
                min = Math.min(i, map.get(target - nums[i]));
            }
        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    private void dig(int[] result, int start) {

    }
}
