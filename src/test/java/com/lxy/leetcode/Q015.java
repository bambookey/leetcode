package com.lxy.leetcode;

import java.util.*;

/**
 * 虽然一次AC，但是是很糟糕的代码
 *
 * Created by lixiangyu on 2018/10/10.
 */
public class Q015 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<String> r = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int expected = 0 - nums[i] - nums[j];
                if (cache.containsKey(expected) && cache.get(expected) > j) {
                    if (!r.contains("" + nums[i] + nums[j] + expected)) {
                        r.add("" + nums[i] + nums[j] + expected);
                    } else {
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(expected);
                    result.add(list);
                }
            }
        }

        return result;
    }
}
