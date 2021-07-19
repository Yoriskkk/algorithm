package com.codetop._1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
@Slf4j
public class LongestCommonSubsequence {

    /**
     * 思路：
     * 使用双指针
     * 首先判断两个字符串的长度
     * 用短的字符串去匹配长的
     * 如果字符相等，则同时往后移一位
     * 如果不相等，长字符则往后移一位
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        if (text1.length() > text2.length()) {
            return getCommonSubsequenceLength(text1, text2, res);
        } else {
            return getCommonSubsequenceLength(text2, text1, res);
        }
    }

    private int getCommonSubsequenceLength(String longStr, String shortStr, int res) {
        int index = 0;
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = index; j < longStr.length(); j++) {
                if (shortStr.charAt(i) == longStr.charAt(j)) {
                    res++;
                    index = j+1;
                    i++;
                    continue;
                }
            }

        }
        return res;
    }

    /**
     * 使用动态规划
     * 状态定义：
     * dp[i][j] text1[0:i-1]和text2[0:j-1]的最长公共子序列
     *
     * 状态转移方程：
     * 如果text1[i] == text2[j]
     * dp[i][j] = dp[i-1][j-1] + 1
     * 如果不相等
     * dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
     *
     *basecase
     * dp[0][j] = 遍历text2中，看是否有一个字符等于text1[0]
     * dp[i][0] = 遍历text1中，看是否有一个字符等于text2[]
     *
     * dp[0][0] 判断text1[0] == text2[0]
     *
     * return dp[text1.length-1][text2.length-1]
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        if(text1.charAt(0) == text2.charAt(0)){
            dp[0][0] = 1;
        }else {
            dp[0][0] = 0;
        }

        for (int i = 1; i < text1.length(); i++) {
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }else {
                dp[i][0] = dp[i-1][0];
            }

        }
        for (int i = 1; i < text2.length(); i++) {
            if(text2.charAt(i) == text1.charAt(0)){
                dp[0][i] = 1;
            }else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                log.info("dp[{}][{}]={}",i,j,dp[i][j]);
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }

    @Test
    public void test(){
        Assert.assertEquals(3,longestCommonSubsequence2("abcde","ace"));
    }
}
