package com.codetop.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CoinChange {

    /**
     * dp[i]的含义 凑出总金额为amount的最少硬币个数
     *
     * 状态转移方程
     * dp[i] = min(dp[i-coin[0]],dp[i-coin[1]],...,dp[i-coin[j]])+1
     *
     * 如果min(dp[i-coin[0]],dp[i-coin[1]],...,dp[i-coin[j]])等于0，就不加1
     *
     * 初始值
     * dp[0] = 0
     *
     * return dp[amount]
     *
     *
     * public int coinChange(int[] coins, int amount) {
     *             if(coins.length == 0){
     *                 return -1;
     *             }
     *             int[] dp=new int[amount+1];
     *             dp[0]=0;
     *             for(int i = 1;i<=amount;i++){
     *                 int min = Integer.MAX_VALUE;
     *                 for (int j = 0;j<coins.length;j++){
     *                     if(i-coins[j]>=0 && dp[i-coins[j]] < min){
     *                         min = dp[i-coins[j]];
     *                     }
     *                 }
     *                 dp[i]=(min==Integer.MAX_VALUE?Integer.MAX_VALUE:min+1);
     *             }
     *             return dp[amount]==Integer.MAX_VALUE ? -1:dp[amount];
     *         }
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
            System.out.println(dp[i]);
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]);
                }
            }
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i] = dp[i] +1;
            }
            System.out.println(dp[i]);
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    public void test(){
        /**
         * coins = [1, 5, 11], amount = 15
         *
         * [186,419,83,408]
         * 6249
         * 输出：
         * 15
         * 预期结果：
         * 20
         */
        int[] nums = new int[]{2};
        Assert.assertEquals(0,coinChange2(nums,3));
    }

}
