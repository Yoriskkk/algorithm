package com.algorithm.hundred;

import com.algorithm.list.ListNode;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 448.找到所有数组中消失的数字
 * 给定一个范围在1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组
 * 数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
@Slf4j
public class _10findDisappearedNumbers {
    /**
     * 思路1：对数组进行去重，然后排序,然后对数组进行遍历，然后依次放入到结果集合中
     *
     * 题意理解错误，丢失n=nums.length条件
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]+1!=nums[i+1]&&nums[i] != nums[i+1]){
                int length = nums[i+1] - nums[i];
                for (int j = 1; j < length; j++) {
                    list.add(nums[i]+j);
                }
            }
        }
        return list;
    }

    /**
     * 思路2：使用哈希表存储数组元素，然后从1开始遍历数组的长度，如没有containsKey 为false就add
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumber2(int[] nums) {
        long startTime = System.currentTimeMillis();
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>(nums.length+1);
        long startBuildMapTime = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],true);
        }
        long endBuildMapTime = System.currentTimeMillis();
        log.info("build hashmap waste time :{}",endBuildMapTime-startBuildMapTime);
        List<Integer> result = new LinkedList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            if(!map.containsKey(i)){
                result.add(i);
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("hashmap waste time :{}",endTime-startTime);
        return result;
    }

    /**
     * 思路3：最快解法
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumber3(int[] nums) {
        long startTime = System.currentTimeMillis();
        boolean[] tmp = new boolean[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]] = true;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < tmp.length ; i++) {
            if(!tmp[i]){
                result.add(i);
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("boolean tmp waste time :{}",endTime-startTime);
        return result;

    }

    public static void main(String[] args) {
        int[] arr = new int[1001000];
        Random random = new Random();
        for (int i = 0; i < 1001000; i++) {
            arr[i] = random.nextInt(1000000);
        }

        findDisappearedNumber2(arr);
        findDisappearedNumber3(arr);
    }
}
