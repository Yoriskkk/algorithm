package com.algorithm.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 */
public class Exchange {

    public static int[] exchange(int[] nums) {
        /**
         * 思路，判断第一个数是奇数还是偶数，走
         * 不同的逻辑，
         * 如果是奇数，那么和后一个数相加
         *      如果是偶数，那么说明该数是奇数
         *      如果是奇数，那么说明该数是偶数
         * 由于需要不断的修改元素的位置，这里使用LinkedList
         */
        List list1 = new ArrayList();
        List list2 = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                list1.add(nums[i]);
            }else {
                list2.add(nums[i]);
            }
        }
        list2.addAll(list1);

        Object[] objects = list2.toArray(new Object[list2.size()]);
        int[] arr = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            arr[i] = (Integer) objects[i];
        }
        return arr;

    }

    public static void main(String[] args) {

        int[] arr = new int[3];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 4;
        exchange(arr);

    }

}
