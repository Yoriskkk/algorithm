package com.codetop.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * 0,1背包问题
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
 * 其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>
 * 举个简单的例子，输入如下：
 * <p>
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * return 6
 */
public class knapsack {

    /**
     * dp[n][w] 前N个物品，背包容量为w ，最多能装的价值dp[n][w]
     * <p>
     * basecase
     * dp[0][w] = 0 ,理解为0个物品，就算有容量，也没有价值
     * dp[n][0] = 0 ,理解为前n个物品，但是没有容量，也装不了价值
     *
     * @param W
     * @param N
     * @param wt
     * @param val
     * @return
     */
    public int knapsack(int W, int N, int[] wt, int[] val) {

        int[][] dp = new int[N + 1][W + 1];
        //因为数组初始化的值为0，所以就可以省掉这个步骤
        /*for (int i = 0; i < W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < N; i++) {
            dp[N][0] = 0;
        }*/
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    @Test
    public void test(){
        Assert.assertEquals(6,knapsack(4,3,new int[]{2,1,3},new int[]{4,2,3}));
    }

}
