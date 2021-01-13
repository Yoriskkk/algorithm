package com.algorithm.hundred;

/**
 * 53.最大子序和
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组(子数组最少包含一个元素)
 * 返回其最大和
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class _14maxSubArray {

    /**
     * 思路1：暴力法:
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum>max){
                    max = sum;
                }
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }

    /**
     * 思路2：动态规划，定义变量sum，如果sum大于0代表对结果有增益效果，就加上当前遍历的这一个数反之就不处理
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {

        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            if(sum>0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(sum,ans);
        }

        return ans;
    }

    /**
     * leetcode 最快解法
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果前一个数是大于0的，那么累加
            if(nums[i-1]>=0){
                nums[i] += nums[i-1];
            }
            //如果累加后的当前数大于最大值，将其赋值给maxSum
            if(nums[i] > maxSum){
                maxSum = nums[i];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray2(arr);
    }

}
