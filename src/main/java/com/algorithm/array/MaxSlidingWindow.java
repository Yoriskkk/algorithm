package com.algorithm.array;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int size = nums.length;
        if (size == 0) {
            return new int[0];
        }
        //1.获取结果数组的长度，nums.length - k + 1
        int[] result = new int[size - k + 1];
        //3.以结果数组的长度，进行遍历，Math.max(int[i],sum),然后将结果赋值给max
        for (int i = 0; i < result.length; i++) {
            int max = nums[i];
            for (int j = 0; j < k; j++) {
                max = Math.max(nums[j + i], max);
            }
            result[i] = max;
        }
        return result;

    }

    //暴力法求解
    public static int[] maxSlidingWindow2(int[] nums, int k) {


        int length = nums.length - k + 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {

            int max = Integer.MIN_VALUE;
            for (int j = i; j < k+i; j++) {
                max = Math.max(nums[j],max);
            }
            result[i] = max;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,-1};
        maxSlidingWindow2(nums,1);

    }


}
