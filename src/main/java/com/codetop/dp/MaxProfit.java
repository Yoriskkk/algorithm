package com.codetop.dp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class MaxProfit {

    /**
     * j->0,表示当前不持股
     * j->1,表示当前持股
     * dp[i][j] 表示i这一天结束的时候，手上持股状态为j时，我们持有的现金数
     * basecase：
     * dp[i][0] i这天，不持股
     * 1.昨天不持股，今天什么都不做
     * 2.昨天持股，今天卖出股票（现金增加）
     * dp[i][1] i这天，持股
     * 1.昨天持股，今天什么都不做（现金不变）
     * 2.昨天不持股，今天买入股票
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        dp[0][1][0] = 0;
        //basecase定义错误，导致最终一直没有解出来
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
        }
        return dp[prices.length - 1][1][0];
    }

    /**
     * 买卖股票的最佳时机||
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 买卖股票的最佳时机|||
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        //缺少次数的basecase，导致结果一直有问题
        for (int i = 1; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][2][0];
    }

    /**
     * 188. 买卖股票的最佳时机 IV
     * @param prices
     * @return
     */
    public int maxProfit4(int k,int[] prices) {
        int[][][] dp = new int[prices.length][k+1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        //缺少次数的basecase，导致结果一直有问题
        for (int i = 1; i < k+1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k+1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            log.info("dp[{}][0]={}",i,dp[i][0]);
            //因为dp[i][0]已经使用了一次交易了，所以dp[i-1][0]的值肯定为0
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            log.info("dp[{}][1]={}",i,dp[i][1]);
        }
        return dp[prices.length-1][0];
    }


    @Test
    public void test() {
        /**
         * 输入：[7,1,5,3,6,4]
         * 输出：5
         *
         */
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        Assert.assertEquals(5, maxProfit1(nums));

        int[] nums2 = new int[]{1,2,3,4,5};
        Assert.assertEquals(4, maxProfit3(nums2));
    }

}
