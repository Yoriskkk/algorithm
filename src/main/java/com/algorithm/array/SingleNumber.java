package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

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

}
