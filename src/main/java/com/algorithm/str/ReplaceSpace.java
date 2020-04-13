package com.algorithm.str;

/**
 * 面试题05. 替换空格
 *
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

}
