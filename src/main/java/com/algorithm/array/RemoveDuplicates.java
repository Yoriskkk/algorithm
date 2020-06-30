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

    public int removeDuplicates2(int[] nums) {

        int i = 2;
        if(nums.length < i){
            return nums.length;
        }
        for (int j = 2; j < nums.length; j++) {

            if(nums[j] != nums[j+2] && nums[j] != nums[j+1]){
                nums[i] = nums[j];
                i ++;
                continue;
            }

            if(nums[j] != nums[j+2] && nums[j] == nums[j+1]){
                nums[i] = nums[j];
                nums[i+1] = nums[j+1];
                i += 2;
                continue;
            }
        }
        return i;
    }

}
