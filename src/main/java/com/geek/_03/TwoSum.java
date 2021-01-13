package com.geek._03;


/**
 * 思路1：
 * 1.暴力法求解，两层loop，只要=target，就返回对应的下标数组
 * 2.定义left、right指针，分别从两边向中间收敛，如果和>target，
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }

}
