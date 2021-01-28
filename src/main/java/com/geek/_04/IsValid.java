package com.geek._04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    /**
     * 思路：
     * 使用stack对齐进行push
     * 然后拿出的时候与其map中的value进行比对
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null || s.length()%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                stack.push(chars[i]);
            } else if(stack.size()>0){
                Character pop = stack.pop();
                if(!map.get(pop).equals(chars[i])){
                    return false;
                }
            } else {
                return false;
            }
        }
        //失败的case "((",该情况，由于都在map的key中，所以都会放入stack中
        if(stack.size() > 0 ){
            return false;
        }
        return true;
    }

}
