package com.lxy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lixiangyu on 2018/11/14.
 */
public class Q054 {

    public static void main(String[] args) {
        Q054 q054 = new Q054();

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(q054.spiralOrder(arr).toArray()));
        ;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = matrix.length - 1;
        int bottom = 0;

        List<Integer> result = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[bottom][i]);
            }
            bottom++;
            if (bottom > top || left > right) {
                break;
            }
            for (int i = bottom; i <= top; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (bottom > top || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[top][i]);
            }
            top--;
            if (bottom > top || left > right) {
                break;
            }
            for (int i = top; i >= bottom; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (bottom > top || left > right) {
                break;
            }
        }

        return result;

    }

}
