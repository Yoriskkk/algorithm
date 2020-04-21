package com.algorithm.array;

import java.util.*;

/**
 * 面试题57. 和为s的两个数字
 */
public class TwoSum {

    /**
     * 暴力解法，超时
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>target){
                size = i+1;
            }
        }
        for (int i = 0; i < size; i++) {

            for (int j = i+1; j < size; j++) {

                int result = nums[i]+nums[j];
                if(result == target){
                    int[] arr = new int[2];
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                    return arr;
                }
            }
        }
        return null;

    }
    /**
     * 使用双指针，基本思路首位双指针，
     * 如果和大于target，那么尾部指针--
     * 如果和小于target，那么首部指针++
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        int start = 0;
        int end = nums.length;
        for (int i = start; i < nums.length;) {
            if((nums[i]+nums[end])>target){
                end--;
                continue;
            }else if ((nums[i]+nums[end])<target){
                i++;
                continue;
            }else {
                int[] arr = new int[2];
                arr[0] = nums[i];
                arr[1] = nums[end];
                return arr;
            }
        }
        return null;

    }


    public static void main(String[] args) {



    }

}
