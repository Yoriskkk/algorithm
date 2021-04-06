package com.geek._05;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    /**
     * 方法1：暴力法，两层loop
     * 方法2：使用hash表
     * 使用containsKey(target - nums[i])
     *  如果为true那么当前i和target - nums[i]对应值的index就是答案
     *  否则的话就map.put（key,nums[i]）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
