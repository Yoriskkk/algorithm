package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MasterMind {


    public int[] masterMind(String solution, String guess) {
        int count1 = 0;
        int count2 = 0;
        //找出count1的答案
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if(solution.charAt(i) == guess.charAt(i)){
                count1++;
            }else {
                a.append(solution.charAt(i));
                b.append(guess.charAt(i));
            }
        }
        //找出count2的答案;
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if(b.charAt(i) == a.charAt(j)){
                    count2++;
                    break;
                }
            }
        }
        return new int[]{count1,count2};
    }

    /**
     * 输入： solution="RGBY",guess="GGRR"
     * 输出： [1,1]
     *
     * "YBBY"
     * "GYYB"
     *
     * [0,3]
     */
    @Test
    public void test(){

        String solution="RGBY";
        String guess="GGRR";
        int[] ints = masterMind(solution, guess);
        Assert.assertEquals(1,ints[0]);
        Assert.assertEquals(1,ints[1]);
    }

}
