package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/11/10.
 */
public class Q048 {
    public static void main(String[] args) {
        Q048 q048 = new Q048();
        int[][] matrix = {};
        q048.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i && j <= len - i - 1; j++) {
                switchMartrix(i, j, matrix);
            }
        }
    }

    public void switchMartrix(int x, int y, int[][] matrix) {
        int len = matrix.length;
        int tmp = matrix[x][y];
        int x1 = len - y - 1;
        int y1 = x;
        matrix[x][y] = matrix[x1][y1];

        int x2 = len - y1 - 1;
        int y2 = x1;
        matrix[x1][y1] = matrix[x2][y2];

        int x3 = len - y2 - 1;
        int y3 = x2;
        matrix[x2][y2] = matrix[x3][y3];

        matrix[x3][y3] = tmp;
    }
}
