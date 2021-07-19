package com.codetop.dp;

public class MinPathSum2 {

    /**
     * 状态定义
     * dp[i][j] 从左上角到左边i,j的路径和最小
     *
     * 状态转移方程
     * dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     *
     * basecase
     * dp[0][j] =
     * dp[i][0] =
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int rowSum = 0;
        int column = 0;
        for (int i = 0; i < grid.length; i++) {
            rowSum += grid[i][0];
            dp[i][0] = rowSum;
        }
        for (int i = 0; i < grid[0].length; i++) {
            column += grid[0][i];
            dp[0][i] = column;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];

    }

}
