package com.algorithm.array;

public class RemoveDuplicates2 {

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(j >= nums.length-2){
                for (int k = 0; k < nums.length-j; k++) {
                    nums[i+k] = nums[j+k];
                }
                i = i+(nums.length-j);
                break;
            }

            if(nums[j]!=nums[j+2]){
                nums[i] = nums[j];
                nums[i+1] = nums[j+1];
                j++;
                i += 2 ;
            }
        }
        return i;
    }
    //[1,2,2,2]
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,2,2};
        int i = removeDuplicates(arr);

    }
}
