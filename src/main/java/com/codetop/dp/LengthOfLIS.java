package com.codetop.dp;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLIS {

    /**
     * 1.dp[i]的含义
     * dp[i]代表，以nums[i]结尾的递增子序列的长度
     * 要想求得dp[i]，那么就要求出dp[i] = Math.max(dp[0],dp[1],dp[2],...,dp[i-1],dp[i])
     * 2.状态转移方程
     * 3.初始值
     * dp[0] = 1
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //为dp中的每一个index赋值
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;//因为每一个子序列肯定包含自身，所以起始值是1
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        //找到每一个下标0~nums.length-1的最长递增子序列，然后取他们的最大值
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    @Test
    public void test(){
        /**
         * 输入：nums = [10,9,2,5,3,7,101,18]
         * 输出：4
         */
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        Assert.assertEquals(4,lengthOfLIS(nums));
    }
}
