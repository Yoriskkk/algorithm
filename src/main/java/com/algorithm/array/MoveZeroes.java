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























    public void moveZeroes1(int[] nums){

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public void moveZeroes2(int[] nums){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=0){
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
        }
    }
















    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }

}
