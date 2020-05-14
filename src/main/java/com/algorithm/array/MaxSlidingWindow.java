package com.algorithm.array;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int size = nums.length;
        if(size == 0){
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

}
