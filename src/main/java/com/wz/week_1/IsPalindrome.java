package com.wz.week_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 * 1.由于特殊字符穷举不完，可以构造一个只有a~z和0~9的map
 * 2.使用双指针，从两侧开始往中间夹逼
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        //构造只有字母和数字的map
        Map<String,String> map = new HashMap<>();
        for (int i = 97; i < 123; i++) {
            map.put(String.valueOf((char)i),"");
        }
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i),"");
        }

        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(map.get(String.valueOf(s.charAt(left)).toLowerCase()) !=null){
                if(map.get(String.valueOf(s.charAt(right)).toLowerCase()) !=null) {
                    String leftStr = String.valueOf(s.charAt(left));
                    String rightStr = String.valueOf(s.charAt(right));
                    if (!leftStr.equalsIgnoreCase(rightStr)) {
                        return false;
                    }
                    right--;
                }else {
                    right --;
                    continue;
                }
                left ++;
            }else {
                left++;
                continue;
            }
        }
        return true;
    }

    @Test
    public void test(){
        isPalindrome("race a car");
    }

}
