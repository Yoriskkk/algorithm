package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IsStraight {

    /**
     * [1,2,3,4,5] true
     * [0,0,1,2,5] true
     * [0,0,1,2,0] true
     * [0,0,1,0,6] false
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        //首先对数组进行排序
        Arrays.sort(nums);
        //然后统计0的个数
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count ++;
                continue;
            }else {
                if(i!=nums.length-1){
                    min = Math.min(min,nums[i]);
                }

            }
            if(i == 0){
                continue;
            }
            if(count == 0){
                if((nums[i] - nums[i-1]) != 1){
                    return false;
                }
            }else {
                if((nums[i] - nums[i-1]) == 0){
                    return false;
                }
            }
        }
        //将nums[length - 1] - nums[](首个非0的数) if(差值>(count + 1)) return false
        if(count>0){
            if((nums[nums.length - 1] - min) > (nums.length - count +1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isStraight(new int[]{10,11,0,12,6});
    }

    @Test
    public void test(){
        Assert.assertEquals(isStraight(new int[]{1,2,3,4,5}),true);
        Assert.assertEquals(isStraight(new int[]{0,0,1,2,5}),true);
        Assert.assertEquals(isStraight(new int[]{0,0,1,2,0}),true);
        Assert.assertEquals(isStraight(new int[]{1,2,3,4,5}),true);
        Assert.assertEquals(isStraight(new int[]{0,0,1,0,6}),true);
        Assert.assertEquals(isStraight(new int[]{0,0,0,0,0}),true);
    }

}
