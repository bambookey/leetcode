package com.lxy.leetcode;

/**
 * 思路：找到最高峰，左右开弓即可了
 *
 * Created by lixiangyu on 2018/11/10.
 */
public class Q042 {
    public static void main(String[] args) {
        Q042 q042 = new Q042();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(q042.trap(arr));
    }

    public int trap(int[] height) {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int result = 0;
        int maxCurr = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > maxCurr) {
                maxCurr = height[i];
            } else {
                result += maxCurr - height[i];
            }
        }
        maxCurr = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > maxCurr) {
                maxCurr = height[i];
            } else {
                result += maxCurr - height[i];
            }
        }
        return result;
    }
}
