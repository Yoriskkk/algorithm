package com.algorithm.hundred;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.多数元素
 * 给定一个大小为n的数组，找到其中的多数元素，多数元素是指在数组中出现次数大于[n/2]的元素
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class _7majorElement {
    /**
     * 思路1：使用HashMap
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int condition = nums.length/2;
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i],++value);
                if(value > condition){
                    return nums[i];
                }
            }else {
                map.put(nums[i],1);
            }
        }
        return nums[0];
    }




}
