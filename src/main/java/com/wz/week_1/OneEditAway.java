package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

public class OneEditAway {

    /**
     * 思路：
     * 对这两个字符串同时遍历
     * 然后使用一个计数器，统计不同字符的个数
     *      if count > 1 return false;
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length() - second.length())>1){
            return false;
        }
        if((first.length() + second.length()) == 1){
            return true;
        }
        int length = Math.max(first.length(),second.length());
        int count = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        while(firstIndex<length && secondIndex <length){
            if(count>1){
                return false;
            }
            if(first.charAt(firstIndex) != second.charAt(secondIndex)){
                count ++;
                if(first.length() > second.length()){
                    firstIndex++;
                    continue;
                }else {
                    secondIndex++;
                    continue;
                }
            }
            firstIndex++;
            secondIndex++;
        }
        return true;
    }

    public boolean oneEditAway2(String first, String second) {
        if(Math.abs(first.length() - second.length())>1){
            return false;
        }
        if((first.length() + second.length()) == 1){
            return true;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int count = 0;
        if(first.length() > second.length()){

            while(secondIndex < second.length()){
                if(count>1){
                    return false;
                }
                if(first.charAt(firstIndex) != second.charAt(secondIndex)){
                    count ++;
                    firstIndex++;
                    continue;
                }
                firstIndex++;
                secondIndex++;
            }
        }else if(first.length() < second.length()){

            while(firstIndex < first.length()){
                if(count>1){
                    return false;
                }
                if(first.charAt(firstIndex) != second.charAt(secondIndex)){
                    count ++;
                    secondIndex++;
                    continue;
                }
                firstIndex++;
                secondIndex++;
            }
        }else {
            while(firstIndex < first.length()){
                if(count>1){
                    return false;
                }
                if(first.charAt(firstIndex) != second.charAt(secondIndex)){
                    count ++;
                }
                firstIndex++;
                secondIndex++;
            }
        }
        if(count>1){
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        /*Assert.assertEquals(oneEditAway("pale","ple"),true);
        Assert.assertEquals(oneEditAway("pales","pal"),false);
        Assert.assertEquals(oneEditAway("","a"),true);*/
//        Assert.assertEquals(oneEditAway2("a","ab"),true);
        Assert.assertEquals(oneEditAway2("teacher","taches"),false);
    }
}
