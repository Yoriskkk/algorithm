package com.geek._03;

public class MoveZeroes {

    /**
     * 自己的思路：
     * 遇到0，就将0后面的所有数，往前挪一位，然后将
     * <p>
     * 1.loop,count zeros ，双指针
     * 两次for循环，第一次，统计不是0的个数
     * 第二次，如果不是0，就按照长度第一计数的length，依次放入
     * <p>
     * 2.开新数组，如果非0就往前放，如果为0就往后放
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int size = 0;

        //1.如果不是0的元素，我们用size这个下标开始赋值，如果等于0
        //就跳过
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[size++] = nums[i];
            }
        }
        //然后再将size后面的元素赋值为0即可
        for (int i = size; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 2.开新数组，如果 非0就往前放，如果为0就往后放
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] newNums = new int[nums.length];
        for (int i = 0, j = 0, k = nums.length - 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                newNums[j] = nums[i];
                j++;
            } else {
                newNums[k] = 0;
                k--;
            }
        }
        nums = newNums;
    }

    /**
     * 3.遇到非0元素，交换位置,额外声明一个指针指向首位
     *
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes3(nums);
        System.out.println(nums);
    }
}
