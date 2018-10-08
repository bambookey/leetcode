package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/10/8.
 */
public class Q011 {
    public static void main(String[] args) {

        System.out.println();
    }

    public int maxArea(int[] height) {
        int max = -1;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int tmp = (r - l) * Math.min(height[l], height[r]);
            if (tmp > max) {
                max = tmp;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
