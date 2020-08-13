package com.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    public boolean isValid1(String s) {
        Map<Character,Character> map = new HashMap();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        //[ { (
        //思路，判断相邻的元素是否是一对，如果不是就入栈
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {

            if(map.get(chars[i]) == null){
                return false;
            }else {
                if(map.get(chars[i]) == chars[i+1]){

                }else {
//                    stack.
                }
            }
        }
        return false;
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid3(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '{'){
                stack.push('}');
            }else if(charArray[i] == '['){
                stack.push(']');
            }else if(charArray[i] == '('){
                stack.push(')');
            }else if (stack.isEmpty()||stack.pop()!=charArray[i]){
                return false;
            }
        }
        return stack.isEmpty();
    }





    public static boolean isValid4(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '['){
                stack.push(']');
            }else if(chars[i] == '{'){
                stack.push('}');
            }else if(chars[i] == '('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.pop()!=chars[i]){
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        String s = "{[]}";
        boolean b = isValid2(s);
        System.out.println(b);
    }

}
