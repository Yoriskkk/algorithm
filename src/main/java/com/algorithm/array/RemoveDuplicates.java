package com.algorithm.array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(j == nums.length-1){
                nums[i] = nums[j];
                i++;
            }
            if(nums[j] != nums[j+1]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
