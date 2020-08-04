package com.algorithm.array;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int insertPos = 0;
        for (int num : nums){
            if(num!=0){
                nums[insertPos++] = num;
            }
        }
        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }

}
