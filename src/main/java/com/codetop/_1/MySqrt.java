package com.codetop._1;

import org.junit.Test;

public class MySqrt {

    /**
     * 大体思路就是找到mid值，然后不断变换左边界或者右边界
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        int left = 0;
        int right = x;
        int ans = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(mid <= x/mid ){//避免int类型溢出
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        mySqrt(16);
    }

    @Test
    public void test2(){
        //<< 代表左移五位，相当于乘以2的五次方
        System.out.println(2<<5);
    }
}
