package com.algorithm.str;

import java.util.*;

public class FirstUniqChar {

    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap();

        for (int i = 0; i < chars.length; i++) {

            Object put = map.put(chars[i], 0);
            if (put != null) {
                map.put(chars[i], 1);
            }

        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 0){
                return entry.getKey();
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
    }

}
