package com.codetop.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinDistance {

    /**
     * 状态定义：
     * dp[i][j]表示0~i坐标的字符串转换成0~j坐标的字符串使用的最少操作
     * dp[i][0] 表示dp[i-1][0] +1 表示删除操作
     * dp[0][j] dp[0][j-1] + 1表示插入
     * 如果最后一个数不相等
     * dp[1][1] dp[i-1][j-1] +1 表示替换操作
     * 如果最后一个数相等
     * dp[i][j] = dp[i-1][j-1] 表示同时往前移
     *
     * 状态转移方程
     * dp[i][j] = dp[][]
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];//skip，同时往前移
                }else {
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    @Test
    public void test(){
        Assert.assertEquals(1,minDistance("","a"));
    }

}
