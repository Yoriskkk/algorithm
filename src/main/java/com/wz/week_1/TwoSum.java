package com.wz.week_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 *   思路1：暴力法求解
 *   思路2：先做排序，然后双指针
 *   思路3：使用hash表
 */
public class TwoSum {

    /**
     * [0,1,2,3,4] target=7 ,return [3,4]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用双指针有一个问题：
     * 排序后的数组，下标发生了变化，返回的结果也就受到了影响
     * 解决方案，可以使用一个map，提前存好原始数组的下标
     *
     * 由于hashmap无法存放重复元素，所以第二个重复元素会将第一个的下标值给覆盖掉
     * 所以使用双指针好像解不了该题
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        //1.对数组进行排序
        Arrays.sort(nums);
        //2.使用双指针，从两边往中间夹逼
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[left] + nums[right]) == target) {
                return new int[]{map.get(nums[left]), map.get(nums[right])};
            } else if ((nums[left] + nums[right]) > target) {
                right--;
                continue;
            } else {
                left++;
                continue;
            }
        }
        return null;
    }

    /**
     * 使用hashmap
     * 1.使用hashmap的key作为nums[i]，value作为nums的index
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target-nums[i]) != null){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,3};
        twoSum3(arr,6);

    }

}
