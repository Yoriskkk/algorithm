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





    public static int maxArea1(int[] height) {
        int right = height.length - 1;
        int maxArea = 0;
        for (int left = 0; left < right;) {
            int area = getArea(height, right, left);
            maxArea = Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }










    public static int maxArea2(int[] height){
        //核心思路，使用left和right两个指针，左右收敛进行计算最大面积
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        int area = 0;
        while(left<right){
            area = getArea(height,height[right],height[left]);
            maxArea = Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }else if(height[left]==height[right]){
                break;
            } else {
                right--;
            }
        }
        return maxArea;
    }








    private static int getArea(int[] height, int right, int left) {
        return (right-left)*Math.min(height[left],height[right]);
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        maxArea2(nums);


    }
}
