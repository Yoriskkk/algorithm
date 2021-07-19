package com.codetop._1;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {

    /**
     * 暴力法：
     * 遍历整个数组，找出所有递增子序列
     * 然后使用sum，保存递增子序列的长度最大值
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int i = 0;
        while(i<nums.length){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            int j = i+1;
            int max = nums[i];
            while(j<nums.length){
                if(nums[j]>max){
                    list.add(nums[j]);
                    max = nums[j];
                }
                j++;
            }
            maxLength = Math.max(maxLength,list.size());
            i++;
        }
        return maxLength;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp[] = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums2 = new int[]{4,10,4,3,8,9};
        int[] nums3 = new int[]{0,1,0,3,2,3};
//        Assert.assertEquals(4,lengthOfLIS(nums));
//        Assert.assertEquals(3,lengthOfLIS(nums2));
        Assert.assertEquals(4,lengthOfLIS(nums3));


    }

}
