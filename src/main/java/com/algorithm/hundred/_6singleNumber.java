package com.algorithm.hundred;

import java.util.Arrays;

/**
 * 136.只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class _6singleNumber {

    /**
     * 思路1：对数组进行排序，如果和当前位置+1的元素不相等则返回该元素
     * 思路2：使用额外的数据结构hashmap
     * @param nums
     * @return
     */

    public static int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result  ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,4,5,5};
        singleNumber(nums);
    }

}
