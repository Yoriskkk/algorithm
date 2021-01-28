package com.geek._04;

public class LargestRectangleArea {

    /**
     * 暴力法求解：
     * 两层loop，挨个遍历，然后用一个max记录最大面积的值
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 1){
            return heights[0];
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] == 0){
                continue;
            }
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                //计算面积
                max = Math.max(getArea(minHeight,j-i+1),max);
            }
        }
        return max;
    }

    /**
     * 双指针left,right：
     * 如果height[left] > height[right]
     *      right --
     * 如果height[left]<height[right]
     *      left ++
     * 循环终止条件 left>right、
     *
     *
     * 这个题不等同于储水器，因为这个题中间就凹下去的高度，如果只是单纯从左右边界往中间收拢去计算，就会出现问题
     *
     * 换一个思路，同样是双指针，不过这个指针我们从中间的位置开始外界扩散
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 1){
            return heights[0];
        }
        int max = 0;
        int mid_left = (heights.length/2);
        int mid_right = heights.length/2;
        max = heights[mid_left];
        while(mid_left>=0 && mid_right<heights.length){
            if(heights[mid_left] == 0){
                mid_left --;
                continue;
            }
            if(heights[mid_right] == 0){
                mid_right ++;
                continue;
            }
            if(heights[mid_left] > heights[mid_right]){
                max = Math.max(getArea(heights[mid_right],mid_right-mid_left+1),max);
                mid_right ++;
            }else {
                max = Math.max(getArea(heights[mid_left],mid_right-mid_left+1),max);
                mid_left --;
            }
        }
        return max;
    }


    private static int getArea(int height, int width) {
        return height*width;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,0,2};
        largestRectangleArea2(arr);

    }

}
