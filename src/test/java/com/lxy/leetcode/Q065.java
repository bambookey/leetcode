package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/12/12.
 */
public class Q065 {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int dp[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[0][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[h - 1][w - 1];
    }
}
