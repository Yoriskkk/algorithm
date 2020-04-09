package com.algorithm.str;

/**
 * 面试题58 - II. 左旋转字符串
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {

        String str = s.substring(0, n);
        String left = s.substring(n);
        return left+str;
    }

}
