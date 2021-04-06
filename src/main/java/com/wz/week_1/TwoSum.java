package com.wz.week_1;

import java.util.Arrays;

public class TwoSum {

    /**
     * [0,1,2,3,4] target=7 ,return [3,4]
     * 思路1：暴力法求解
     * 思路2：先做排序，然后双指针
     * 思路3：使用hash表，
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * [3,2,4]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        //1.对数组进行排序
        Arrays.sort(nums);
        //2.使用双指针，从两边往中间夹逼
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[left] + nums[right]) == target) {
                return new int[]{left, right};
            } else if ((nums[left] + nums[right]) > target) {
                right--;
                continue;
            } else {
                left++;
                continue;
            }
        }
        return null;
    }
}
