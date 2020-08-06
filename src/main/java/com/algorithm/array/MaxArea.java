package com.algorithm.array;

public class MaxArea {

    public static int maxArea(int[] a) {

        int max = 0;
        for (int i = 0, j = a.length - 1; i < j;) {
            int minHeight = 0;
            int area = 0;
            if(a[i]<a[j]){
                minHeight = a[i];
                area = (j-i)*minHeight;
                i++;
            }else {
                minHeight = a[j];
                area = (j-i)*minHeight;
                j--;
            }
            max = Math.max(max,area);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        maxArea(nums);


    }
}
