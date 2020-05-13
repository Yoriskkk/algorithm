package com.algorithm.array;

public class Search {

    public static int search(int[] nums, int target) {

        int count = 0;
        int length = nums.length;
        if (length % 2 != 0) {
            length = length / 2 + 1;
        } else {
            length = length / 2;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                count++;
            }
            if (nums.length != 1 && ((nums.length - 1 - i)!=i)&&nums[nums.length - 1 - i] == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 因为是排序数组，所以，相等的数是连续的
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else if (count > 0) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        search2(new int[]{1,2,3,2}, 2);
    }

}
