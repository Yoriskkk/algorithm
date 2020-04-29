package com.algorithm.array;

/**
 * 需要补上动态规划的知识
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = new int[9];
        arr[0] = -2;
        arr[1] = 1;
        arr[2] = -3;
        arr[3] = 4;
        arr[4] = -1;
        arr[5] = 2;
        arr[6] = 1;
        arr[7] = -5;
        arr[8] = 4;
        maxSubArray(arr);
    }
}
