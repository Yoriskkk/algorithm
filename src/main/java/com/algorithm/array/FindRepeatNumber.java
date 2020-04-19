package com.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        HashMap map = new HashMap(nums.length);
        List result = new ArrayList();
        for (int num : nums) {
            Integer put = (Integer) map.put(num, 0);
            if (put != null){
                result.add(num);
            }
        }
        int i = (Integer) result.get(0);
        return i;

    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        Object put1 = map.put("1", "1");
//        System.out.println(put1.toString());
        Object put = map.put("1", "2");
        System.out.println(put.toString());
        System.out.println(map.toString());
    }

}
