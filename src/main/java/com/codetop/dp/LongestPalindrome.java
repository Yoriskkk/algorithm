package com.codetop.dp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindrome {

    /**
     * 状态定义
     * boolean[][] dp
     * dp[i][j] 表示i到j是否为回文串
     *
     * 状态转移方程
     * dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
     *
     * retuan Math.max(dp[0]~dp[i])
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res;
        int lenMax = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j > 0; j--) {
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }else {
                    dp[i][j] = false;
                }

            }
        }
        return null;

    }

    /**
     * 暴力法求解
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        /*for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(){

                }
            }
        }*/
        return null;
    }


    /**
     * 使用从中心开始往外扩散的方法
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //表示以i下标为中心往外扩散(回文串为奇数的情况)
            String a = palindrome(s,i,i);
            //表示以i和i+1为中心往外扩散(回文串为偶数的情况)
            String b = palindrome(s,i,i+1);
            if(a.length() > b.length()){
                if(res.length()<a.length()){
                    res = a;
                }
            }else {
                if(res.length()<b.length()){
                    res = b;
                }
            }
        }
        return res;
    }

    private String palindrome(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return s.substring(left+1,right);
    }

    @Test
    public void test(){
        Assert.assertEquals("bab",longestPalindrome3("babad"));
    }

}
