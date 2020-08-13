package com.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;

public class IsAnagram {

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i:count){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力解法，将两个字符串进行排序之后然后equals比较
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS,charsT);

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram2(s,t);
    }

}
