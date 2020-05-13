package com.algorithm.array;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i + 1] - nums[i]) == 2) {
                return nums[i] + 1;
            }
        }
        return 0;
    }

}
