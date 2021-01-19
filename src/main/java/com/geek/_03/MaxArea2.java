package com.geek._03;

public class MaxArea2 {

    /**
     * 首先题目的意思其实就是找到坐标上最大的面积
     * 1.很容易就能想到使用暴力法，两层loop，依次算出
     * 当前的一个面积，然后使用max去记录
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //计算当前的面积
                int area = (j - i) * Math.min(height[j], height[i]);
                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }

    /**
     * 第二种思路的话，就是使用双指针夹逼
     * 定义left、right指针
     * 如果左边比较大，那么right指针--
     * 如果有变指针比较大，那么left指针++
     * 循环终止条件为left>=right
     * 这样的时间复杂度就是O(n)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
    }
}
