package com.geek._03;

/**
 * 思路1：
 * 1.第一个loop统计非零元素的个数，然后额外生命一个指针，从0开始，重新赋值原数组
 * 2.第二个loop从非零元素的size开始，然后往后遍历赋值0
 * 思路2：
 * 1.还是需要额外声明一个指针，从0开始，在loop的过程中，如果遇到非零元素就交换赋值给新指针的位置的元素，然后，新指针++
 * 思路3：
 * 1.额外声明一个数组，遇到非零元素往头部赋值，遇到零元素就往尾巴赋值
 *
 */
public class MoveZeroRepeat {

    /**
     * 思路1解法
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //1.对空数组和null进行拦截
        if(nums == null || nums.length == 0){
            return;
        }
        //2.声明新的指针变量
        int size = 0;
        //3.第一次loop，计数非零元素
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[size++] = nums[i];
            }
        }
        for (int i = size; i < nums.length; i++) {
            nums[i] = 0;
        }
        //4.第二次loop，从非零元素个数的size位置开始遍历到数组末尾，赋值0
    }

    /**
     * 思路2解法
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        //1.对空数组和null进行拦截
        if(nums == null || nums.length == 0){
            return;
        }
        //2.声明新的指针变量
        int size = 0;
        //3.一次loop，然后交换非零元素
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[size];
                nums[size] = nums[i];
                nums[i] = temp;
                size++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println(nums);
    }
}
