package com.codetop._1;

import org.junit.Test;

public class Merge {
    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 思路：
     * 将nums2先加入到nums1中
     * i指向nums1的起点
     * j指向nums2的起点
     * 如果nums1[i] > nums[j] 就swap，该思路最终没有通过
     *
     * 思路2：
     * 先不对nums1进行填充
     * 使用i、j分别作为nums1和nums2的起始位置
     * if(nums1[i] > nums2[j]){
     *     //插入元素nums2[j]
     *     //nums1[i]以及i以后的所有元素往后移动
     *     j++
     * }
     *
     * 思路3：
     * 对nums1进行填充，填充的数字为有效元素的最后一位
     *
     * 思路4：
     * 双指针同时从最后开始遍历
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge4(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1; //从末尾开始
        int j = n - 1; //从末尾开始
        int k = m + n - 1; //从末尾开始
        while (j >= 0) {
            if (i < 0) {
                while (j >= 0) {
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            //哪个数大就对应的添加哪个数。
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n){
        if(n == 0){
            return;
        }
        //fill nums1
        if(m-1<0){
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int nums1Max = nums1[m-1];
        int nums2Min = nums2[0];
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums1Max;
        }
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        while(i>=0){
            //nums1中后面的元素
            if(i >= m ){
                if(nums2[j] > nums1[i]){
                    nums1[i] = nums2[j];
                }
                i--;
                j--;
                continue;
            }

            if(nums1[i] > nums2Min){
                nums1[i] = nums2Min;
            }
            i--;
            continue;
        }

    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0){
            return;
        }
        if(m == 0){
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = 0;
        int j = 0;
        while(j<n){
            if(nums1[i] > nums2[j]){
                //先将元素nums1[i]及其以后的元素往后挪一位，挪动的数量为m-i个位置
                moveArrayOneStep(nums1,i);
                //插入元素nums2[j]到nums1[i]
                nums1[i] = nums2[j];
                j++;
            }
            if(i == m-1+j){//代表遍历到了原有nums1的末尾
                if(j<n){
                    //将nums2[j]以后的元素拼在nums1[i+1]及其以后
                    for (int k = i+1; k < nums1.length; k++) {
                        nums1[k] = nums2[j];
                        j++;
                    }
                }
            }
            i++;
        }
    }

    private void moveArrayOneStep(int[] nums1, int i) {
        for (int j = nums1.length-1; j >i ; j--) {
            nums1[j] = nums1[j-1];
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,0,0,0};
        moveArrayOneStep(arr,2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0){
            return;
        }
        //add nums2 to nums1
        for (int i = m,j=0; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        for (int i = 0; i < nums1.length-1; i++) {
            if(nums1[i] > nums1[i+1]){
                swap(nums1,i,i+1);
            }
        }
    }

    private void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     *
     * [1,2,3,0,0,0]
     * 3
     * [2,5,6]
     * 3
     *
     * [2,0]
     * 1
     * [1]
     * 1
     *
     * [2,0]
     * 1
     * [1]
     * 1
     *
     * [4,0,0,0,0,0]
     * 1
     * [1,2,3,5,6]
     * 5
     *
     * [1,2,3,0,0,0]
     * 3
     * [2,5,6]
     * 3
     *
     * [1,2,4,5,6,0]
     * 5
     * [3]
     * 1
     *
     * [1,2,3,0,0,0]
     * 3
     * [2,5,6]
     * 3
     *
     * [4,5,6,0,0,0]
     * 3
     * [1,2,3]
     * 3
     *
     * [1,2,3,0,0,0]
     * 3
     * [2,5,6]
     * 3
     *
     * [0]
     * 0
     * [1]
     * 1
     *
     * 最后执行的输入：
     * [2,0]
     * 1
     * [1]
     * 1
     *
     * [2,0]
     * 1
     * [1]
     * 1
     *
     */
    @Test
    public void test(){
        int[] nums1 = new int[]{2,0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        merge4(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

}
