package com.lxy.leetcode;

import java.util.Arrays;

/**
 * Created by lixiangyu on 2018/11/26.
 */
public class Q059 {

    public static void main(String[] args) {
        Q059 q059 = new Q059();
        System.out.println(Arrays.toString(q059.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int num = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right && up <= down; i++) {
                matrix[up][i] = ++num;
            }
            up++;
            for (int i = up; i <= down && left <= right; i++) {
                matrix[i][right] = ++num;
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                matrix[down][i] = ++num;
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                matrix[i][left] = ++num;
            }
            left++;
        }
        return matrix;
    }

}

