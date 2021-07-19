package com.codetop.dp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class Rob {

    /**
     * 状态定义
     * dp[i][0] = 偷窃第i号房间的最大金融
     * dp[i][1] = 不偷窃第i号房间的最大金额
     * 答案就是取他们两者的最大值
     *
     * 状态转移方程
     * dp[i][0] = dp[i-1][1] + nums[i],第i天，偷盗的最大金额=前一天不偷+今天的房间的金额
     * dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]),第i天不偷的最大金额=Math.max(前一天不偷，前一天偷)
     *
     * basecase
     * dp[0][0] = nums[0]
     * dp[0][1] = 0
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            //第i天决定偷，所以是前一天的不偷+当前的金额
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    /**
     * 213.打家劫舍||
     * 差异在于第一家和最后家也是相邻的，需要对这种case进行判断
     * 状态定义
     * dp[i][0] ,表示第i家偷
     * dp[i][1],表示第i家不偷
     * 答案是偷盗最后一家，Math.max(dp[len-1][0],dp[len-1][1])
     *
     * 状态转移
     * dp[i][0] = dp[i-1][1] + nums[i]
     * dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0])
     *
     * 需要判断如果i == len-1
     *      if(dp[0][0] == nums[0]){
     *
     *      }
     * dp[i][0] =
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[][][] dp = new int[nums.length][2][2];
        dp[0][0][0] = nums[0];
        dp[0][1][1] = 0;
        dp[0][0][1] = 0;
        dp[0][1][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2; j++) {
                if(i == nums.length-1){
                    if(j==0){
                        dp[i][1][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j]);
                    }else if(j==1){
                        dp[i][0][j] = dp[i-1][1][j] + nums[i];
                        dp[i][1][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j]);
                    }
                }else {
                    dp[i][0][j] = dp[i-1][1][j] + nums[i];
                    dp[i][1][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j]);
                }
            }

        }
        return Math.max(dp[nums.length-1][1][0],Math.max(dp[nums.length-1][1][1],dp[nums.length-1][0][1]));
    }

    /**
     * 打家劫舍||优化版本
     * @param nums
     * @return
     */
    public int rob23(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[][][] dp = new int[nums.length][2][2];
        dp[0][0][0] = nums[0];
        dp[0][1][1] = 0;
        dp[0][0][1] = 0;
        dp[0][1][0] = 0;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < 2; j++) {
                if(i == nums.length-1){
                    if(j==0){
                        dp[i][1][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j]);
                    }else if(j==1){
                        dp[i][0][j] = dp[i-1][1][j] + nums[i];
                        dp[i][1][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j]);
                    }
                }else {
                    dp[i][0][j] = dp[i-1][1][j] + nums[i];
                    dp[i][1][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j]);
                }
            }

        }
        return Math.max(dp[nums.length-1][1][0],Math.max(dp[nums.length-1][1][1],dp[nums.length-1][0][1]));
    }


    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,1};
        Assert.assertEquals(4,rob(nums));
    }

}
