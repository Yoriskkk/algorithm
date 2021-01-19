package com.geek._03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * 首先比较容易想到的就是暴力法
     * 三层loop，只要找到为0的元素就往数组中添加元素
     * 除此之外需要考虑去重
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if((nums[i]+nums[j]+nums[k]) == 0){
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        addfilter(list,innerList);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 往list中添加元素的时候，需要对其进行去重
     * @param list
     * @param innerList
     */
    private static void addfilter(List<List<Integer>> list, List<Integer> innerList) {
        if(!list.contains(innerList)){
            list.add(innerList);
        }
    }


    /**
     * 看了下题解的思路
     * 应该是定义左右指针，然后从index = 1开始 loop
     * 如果总和>0，则右指针--
     * 如果总和<0,则左指针++
     * 如果总和=0，将其组合加到结果list中，然后index++
     * 循环终止条件为：cur == right
     *
     *
     * 重新看了题解之后
     * 时间复杂度为O(Nlogn)
     * 思路就是：
     * 两层loop
     * 外层loop固定一个数，然后逐步++
     * 内层loop定义左右指针,left = cur+1,right=nums.length-1
     * 如果threesum=0，就加到结果的集合中
     *      该分支下需要去重，跳过后续相等的数
     * 如果threesum>0,那么right--
     * 如果threesum<0,那么left++
     * 需要注意的是一些去重的条件，比如nums[cur] = nums[cur-1]那么应该跳过
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length-2; left++) {
            if(nums[left]>0){
                break;
            }
            if(left>0 && nums[left] == nums[left - 1]){
                continue;
            }
            int right = nums.length-1;
            for (int cur = left+1; cur < right;) {
                if((nums[left] + nums[cur] + nums[right])==0){
                    List innerList = new ArrayList(3);
                    innerList.add(nums[left]);
                    innerList.add(nums[right]);
                    innerList.add(nums[cur]);
                    list.add(innerList);
                    while (cur<right && nums[cur] ==nums[cur+1]) cur++;//去重
                    cur ++;
                }else if((nums[left] + nums[cur] + nums[right])<0){
                    cur ++;
                }else {
                    right --;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum2(nums);
    }
}
