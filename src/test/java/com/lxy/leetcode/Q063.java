package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/12/8.
 */
public class Q063 {
    public static void main(String[] args) {
        int[][] grid = {{0}, {0}};
        Q063 q063 = new Q063();
        System.out.println(q063.uniquePathsWithObstacles(grid));
    }

    /**
     * 相比之下leetcode大佬的代码比我的思路要清晰许多，额外分配内存空间会使代码可读性大大提高
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;

        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[h - 1][w - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1 || obstacleGrid[i][j] == -1) {
                    obstacleGrid[i][j] = -1;
                } else {
                    int a = 0;
                    if (i - 1 >= 0) {
                        a = obstacleGrid[i - 1][j] < 0 ? 0 : obstacleGrid[i - 1][j];
                    }
                    int b = 0;
                    if (j - 1 >= 0) {
                        b = obstacleGrid[i][j - 1] < 0 ? 0 : obstacleGrid[i][j - 1];
                    }
                    obstacleGrid[i][j] = a + b;
                }
            }
        }

        return obstacleGrid[h - 1][w - 1] < 0 ? 0 : obstacleGrid[h - 1][w - 1];
    }
}
