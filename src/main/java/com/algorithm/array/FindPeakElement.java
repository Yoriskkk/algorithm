package com.algorithm.array;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if(nums == null){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            if(nums[0] == Math.max(nums[0],nums[1]))
                return 0;
            return 1;
        }

        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]>nums[i-1] && nums[i]<nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

}
