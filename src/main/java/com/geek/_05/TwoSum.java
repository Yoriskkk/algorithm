package com.geek._05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 1暴力法
     * 两层loop
     *  挨个遍历
     * 2.使用hash表
     * 对于map中比较
     *  如果map.containsKey(targer - nums[i])
     *      说明当前遍历到的值和target - nums[i]对应的下标值即为答案
     *      false：
     *      就map.put(nums[i],i)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
