package com.geek._03;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路1：
 * 1.暴力法？三层loop，找出所有的组合
 *
 * 思路2：
 * 1.由两数之和受到的启发，a+b+c = 0，其实就是在找a+b =-c，所以这里其实可以将所有(数*-1)存入hash表
 * 然后就变成了两层循环
 */
public class ThreeSum {

    /**
     * 方法一,由于未去重，失败
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k] == 0){
                        ArrayList<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        result.add(innerList);
                    }
                }
            }
        }
        return result;

    }

}
