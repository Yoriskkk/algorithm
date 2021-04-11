package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DivingBoard {

    /**
     * 思路：
     * 1.使用暴力法
     * loop{
     *     遍历k次，shorter
     *     loop{
     *         遍历
     *     }
     *
     * }
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public static int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return new int[]{};
        }
        if(shorter == longer){
            return new int[]{k*shorter};
        }
        int[] resultArray = new int[k+1];
        int result = 0;
        int sumCount = k;
        while(sumCount>=0){
            int shorterCount = sumCount;
            int longerCount = k - shorterCount;
            int subResult = 0;
            subResult = shorterCount * shorter + longerCount * longer;
            resultArray[k-sumCount] = subResult;
            sumCount--;
        }
        return resultArray;
    }

    @Test
    public void test1(){
        Assert.assertEquals(divingBoard(1,1,0),new int[]{});
    }

    @Test
    public void test2(){
        Assert.assertEquals(divingBoard(1,1,100000),new int[]{100000});
    }

    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 3;
        divingBoard(1,2,3);
    }

}
