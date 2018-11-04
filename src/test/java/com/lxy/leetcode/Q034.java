package com.lxy.leetcode;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 * Created by lixiangyu on 2018/11/4.
 */
public class Q034 {
    public int[] searchRange(int[] nums, int target) {

        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                ret[0] = left;
                ret[1] = right;
                break;
            }

            mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (nums[right] == target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return ret;

    }
}
