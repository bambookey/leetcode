package com.lxy.leetcode;

/**
 * 洗牌：for + swap
 *
 * Created by lixiangyu on 2018/9/1.
 */
public class Q384 {

    int[] arr;

    public Q384(int[] nums) {
        arr = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] cp = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++) {
            cp[i] = arr[i];
        }
        int min = arr.length > 3 ? 3 : arr.length;
        for (int i = 0; i < min; i++) {
            int randomIndex = (int) (Math.random() * (arr.length));
            int tmp = cp[i];
            cp[i] = cp[randomIndex];
            cp[randomIndex] = tmp;
        }
        return cp;
    }
}
