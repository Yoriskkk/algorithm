package com.algorithm.array;

import java.util.LinkedList;

public class Rotate {

    public static void rotate(int[] nums, int k) {
        int shift = k % nums.length;
        int[] arr1 = nums.clone();
        int[] arr2 = nums.clone();

        int i = 0;
        for (int j = shift+1; j < nums.length; j++) {
            nums[i] = arr1[j];
            i++;
        }
        for (int j = 0; j < shift; j++) {
            nums[i] = arr2[j];
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
    }
}
