package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 */
public class MajorityElement {

    public  static  int majorityElement(int[] nums) {

        int size = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            Integer put = map.put(nums[i], 1);
            if (put != null) {
                map.put(nums[i], size++);
            }else {
                map.put(nums[i], 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(size)){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = new int[9];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 5;
        arr[7] = 4;
        arr[8] = 2;

        majorityElement(arr);

    }
}
