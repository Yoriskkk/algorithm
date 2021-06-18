package com.codetop._1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
     * 思路:
     * 使用滑动窗口
     * 使用i、j双指针标识子串的左右边界
     * 使用map，key存字符，value存对应字符的下标
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(i<=j && j< s.length() && i<s.length()){
            if(map.get(s.charAt(j)) == null){
                map.put(s.charAt(j),j);
                j++;
            }else {
                Integer index = map.get(s.charAt(j));
                //如果下标<i，说明该重复值在非重复子串的外面(非连续)
                if(index>=i){
                    i = index+1;
                }
                map.put(s.charAt(j),j);
                j++;
            }
            result = Math.max(j-i,result);
        }
        return result;
    }

    @Test
    public void test(){
        String s = "";
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        //该case可验证上诉index的逻辑，非子串
        String s4 = "abba";
        Assert.assertEquals(0,lengthOfLongestSubstring(s));
        Assert.assertEquals(3,lengthOfLongestSubstring(s1));
        Assert.assertEquals(1,lengthOfLongestSubstring(s2));
        Assert.assertEquals(3,lengthOfLongestSubstring(s3));
        Assert.assertEquals(2,lengthOfLongestSubstring(s4));
    }



}
