package com.codetop._1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    /**
     * 思路：
     * 首先使用hash表将符号存起来
     * s 仅由括号 '()[]{}' 组成
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                stack.push(map.get(s.charAt(i)));
            }else {
                //badcase "){" stack有可能没有元素
                if(stack.size()!=0 && stack.pop().equals(s.charAt(i))){
                    continue;
                }else {
                    return false;
                }
            }
        }
        //badcase "(("
        if(stack.size() != 0){
            return false;
        }
        return true;
    }

}
