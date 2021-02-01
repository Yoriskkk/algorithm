package com.geek._05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    /**
     * 思路1：暴力
     * 对这两个字符串，按照字母顺序排序
     * 然后进行匹配
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS,charsT);
    }

    /**
     * 思路2：
     * 对s这个字符串，使用hashmap存放字符
     * 需要注意的是，重复字符，需要计算频次
     * 可以再遍历t字符串的时候，对该map进行del操作，最后查看map中否没有值即可
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i]) == null){
                map.put(chars[i],1);
            }else {
                Integer integer = map.get(chars[i]);
                map.put(chars[i],++integer);
            }
        }
        char[] charsT = t.toCharArray();
        for (int i = 0; i < charsT.length; i++) {
            if(map.get(charsT[i]) == null){
                return false;
            }else if(map.get(charsT[i]).equals(1)){
                map.remove(charsT[i]);
            }else {
                Integer integer = map.get(charsT[i]);
                map.put(charsT[i],--integer);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        isAnagram2("a","b");
    }

}
