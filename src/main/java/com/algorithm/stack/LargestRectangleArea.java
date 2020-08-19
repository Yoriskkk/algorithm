package com.algorithm.stack;

public class LargestRectangleArea {

    /**
     * 暴力法求解
     * 双层for循环，从左边界开始遍历
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int length = heights.length;
        int maxArea = 0;
        for (int left = 0; left < length; left++) {
            int minHeight = Integer.MAX_VALUE;
            for (int right = left; right < length; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                int curArea = (right - left + 1) * minHeight;
                maxArea = Math.max(curArea, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 第二种暴力解法
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {

        int area = 0, length = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < length; i++) {
            int w = 1, h = heights[i], j = i;
            //往左边找
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            //往右边找
            while (++j < length && heights[j] >= h) {
                w++;
            }
            //记录最大面积
            area = Math.max(area, w * h);
        }
        return area;
    }



}
