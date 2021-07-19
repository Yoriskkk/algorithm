package com.codetop._1;

import org.junit.Test;

public class MaxSubArray {

    /**
     * 定义一个sum 存储组合的最大值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum,nums[i]);
            for (int j = i+1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                if(temp > sum){
                    sum = temp;
                }
            }

        }
        return sum;

    }
    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

}
