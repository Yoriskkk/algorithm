package com.algorithm.array;

import java.lang.reflect.Array;
import java.util.*;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        //1.使用hashmap 数组中的元素存储为key，value为出现的次数，最后取出次数为1 的那个key
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for (Map.Entry entry: map.entrySet()) {
            if(entry.getValue().equals(1)){
                return (Integer) entry.getKey();
            }
        }
        return 0;
    }

    /*public int singleNumber2(int[] nums) {
        List<Integer> list = new ArrayList(nums.length+nums.length/3);
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[]){

            }
            list.add(i,nums[i]);
        }

        return 0;
    }*/

}
