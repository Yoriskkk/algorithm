package com.codetop.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniquePaths {

    /**
     * dp解题的三步骤
     * 1.理解dp[i]后者dp[i][j]的含义
     *  dp[m][n]代表机器人走到m,n坐标的不同路径总数
     * 2.找到dp[i][j]的状态转移方程
     *  dp[m][n] = dp[m-1][n] + dp[m][n-1]
     *  但是这里要注意一下,我们实际要求的值其实是dp[m-1][n-1]
     *  要知道mn坐标的结果，只需要知道目标的上方和目标左方的dp值即可
     * 3.找到初始值
     *  dp[0][0~n],dp[0~m][0],就是第一行和第一列
     *  第一行只能从一行开始往右移，比如dp[0][n]的值 = dp[0][n-1] = 1
     *  第一列同理
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        //对初始值进行赋值,对第一列进行赋值
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        //对第一行进行赋值
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        //return应该直接是结果值，因为在之前穷举中，已经赋值过了
        return dp[m-1][n-1];
    }

    @Test
    public void test(){
        Assert.assertEquals(28,uniquePaths(3,7));
        Assert.assertEquals(3,uniquePaths(1,2));
    }

}
