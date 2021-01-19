package com.geek._03;

/**
 * 思路1：
 * 1.暴力求解法，两层loop，依次算出当前的面积，然后和max做比较
 * 思路2：
 * 1.使用双指针收敛法,定义i,j左右两个下标，如果左边高度大于右边高度，则右边下标往内收敛
 * 否则左边下标往右移动
 *
 */
public class MaxArea {

    /**
     * 思路1解法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        //1.参数校验
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(getCurentArea(height[i], height[j], j - i), maxArea);
            }
        }
        return maxArea;
    }

    private static int getCurentArea(int i, int j, int width) {
        if (i < j) {
            return i * width;
        } else
            return j * width;
    }

    /**
     * 方法2
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {

        //1.参数校验
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0 ,j = height.length-1; i<j;) {
            if(height[i] > height[j]){
                maxArea = Math.max(getCurentArea(height[i], height[j], j - i),maxArea);
                j--;
            }else {
                maxArea = Math.max(getCurentArea(height[i], height[j], j - i),maxArea);
                i++;
            }
        }
        return maxArea;
    }



    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea2(height);
        System.out.println(i);
    }

}
