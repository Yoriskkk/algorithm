package com.geek._04;


import java.util.Stack;

public class MaxSlidingWindow {

    /**
     * 思路1：
     * 定义一个指针i，每次滑动窗口移动，该指针也移动一位
     * 然后在k次循环内找出其中的最大值，放入结果数组中
     * 结果数据的size是多少？
     *      nums.length - k + 1
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 1){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length-k+1; i++) {
            int max = nums[i];
            for (int j = i; j < i+k; j++) {
                if(nums[j] > max){
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }


    /**
     * 方法2：
     * 使用stack去存储当前组的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 1){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length-k+1; i++) {
            int max = nums[i];
            if(stack.peek() > max){

            }
            for (int j = i; j < i+k; j++) {
                if(nums[j] > max){
                    max = nums[j];
                }
            }
            result[i] = max;
            stack.push(max);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,-1};
        int k = 1;
        maxSlidingWindow(nums,k);


    }

}
