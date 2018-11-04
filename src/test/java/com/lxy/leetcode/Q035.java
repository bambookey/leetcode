package com.lxy.leetcode;

/**
 * 这几道题都是二分查找的应用，注意灵活运动就好
 * <p>
 * Created by lixiangyu on 2018/11/4.
 */
public class Q035 {


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target <= nums[left]) {
                return left;
            }
            if (target > nums[right]) {
                return right + 1;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
