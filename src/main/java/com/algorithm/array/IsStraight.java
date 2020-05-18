package com.algorithm.array;

import java.util.Set;
import java.util.TreeSet;

public class IsStraight {

    public boolean isStraight(int[] nums) {

        //1.遍历这个数组
            //1.1获得最小数，最大数，如果最大数减去最小数 <=4就算true
        int max = 0;
        int min = 13;
        int size = 5;
        Set set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 0){
                size --;
                continue;
            }
            set.add(nums[i]);

            if(nums[i] > max){
                max = nums[i];
            }else if(nums[i] == max){
                return false;
            }

            if(nums[i] < min){
                min = nums[i];
            }else if(nums[i] == min){
                return false;
            }

        }

        if(set.size() != size){
            return false;
        }

        if((max - min)<=4){
            return true;
        }

        return false;
    }

}
