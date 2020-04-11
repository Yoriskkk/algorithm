package com.algorithm.str;

/**
 * 面试题05. 替换空格
 *
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                s.charAt(i) = "%20";
            }
        }

    }

}
