package com.demo;

public class MoveZeroes {

    /**
     * 两次遍历，第一次找出所有不为0的元素
     * 第二次将剩下的元素全部赋值为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
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

    /**
     *快慢指针，遇到不为0的元素就和慢指针的数组值交换一下
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=0){
                swap(nums,slow,fast);
                slow++;
            }
        }
    }


    /**
     * 暴力法
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0){
            }
        }
    }

    private static void swap(int[] nums,int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes2(nums);
    }
}
