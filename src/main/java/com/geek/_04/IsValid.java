package com.geek._04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    /**
     * 该题思路1：
     * 使用stack，对字符进行存入
     * 如果s.length为奇数那么直接返回false
     * 如果为偶数
     * 对改字符的前一半进去stack的push操作
     * 在后一半，对stack进行pop，然后依次比较是否equals
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                stack.push(chars[i]);
            } else if (stack.size() > 0) {
                Character pop = stack.pop();
                if (!map.get(pop).equals(chars[i])) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(stack.size() > 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "((";
        isValid(s);
    }

}
