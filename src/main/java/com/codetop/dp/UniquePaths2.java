package com.codetop.dp;

public class UniquePaths2 {


    /**
     *
     * 状态定义
     * dp[i][j] 表示走到第i行，第j列的格子的不同路径总数
     *
     * 状态转移方程
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * basecase
     * dp[0][j] = 1,表示在第一行，只有一种路径走，就是往右
     * dp[i][0] = 1,表示第一列，也只有一种路径走，就是往下
     *
     * 需要求
     * dp[m-1][n-1] = dp[m-2][n-1] + dp[m-1][n-2]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
