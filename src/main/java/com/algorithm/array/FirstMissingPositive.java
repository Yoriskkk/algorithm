package com.algorithm.array;

import java.util.*;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        //大致的思路，将数据元素放入hashset中，然后一个一个contains
        HashSet testSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            testSet.add(nums[i]);
        }
        for (int i = 1; i < length; i++) {
            if(!testSet.contains(i)){
                return i;
            }
        }
        return length+1;
    }

}
