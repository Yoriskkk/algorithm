package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 */
public class RemoveDuplicates {

    /**
     * 使用快慢指针
     * 满指针用来指向结果数组的index
     * 快指针正常遍历
     *      快指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[fast] == nums[slow]){
                continue;
            }
            if(nums[fast]>nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

    @Test
    public void test(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Assert.assertEquals(removeDuplicates(nums),2);
    }

}
