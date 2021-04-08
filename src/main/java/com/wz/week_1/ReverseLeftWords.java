package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class ReverseLeftWords {

    /**
     * 思路：
     * 使用StringBuilder
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder front = new StringBuilder();
        StringBuilder behind = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i<n){
                behind.append(s.charAt(i));
            }else {
                front.append(s.charAt(i));
            }
        }
        s.substring(0,1);
        return front.append(behind).toString();
    }


    @Test
    public void test(){
        String s = "lrloseumgh";
        Assert.assertEquals(reverseLeftWords(s,6),"umghlrlos");
    }

}
