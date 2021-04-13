package com.wz.week_1;

public class CanJump {

    /**
     * 暴力法求解
     * 对第一个元素，进行穷举，然后
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * @param nums
     * @return
     */

    int index = 0;
    public boolean canJump(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int numLength = nums[i];
            if(numLength == 0){
                return false;
            }
            for (int j = 1; j < numLength; j++) {
                if(j+index==nums.length){

                }
            }
        }

        return false;

    }

}
