package com.algorithm.trie;

/**
 * 暴力匹配算法
 */
public class BruteForce {

    public static boolean match(String mainStr,String pattern){

        boolean flag = true;
        for (int i = 0; i < mainStr.length()-pattern.length()+1; i++) {

            in:for (int j = 0; j < pattern.length(); j++) {
                if(mainStr.charAt(i+j) != pattern.charAt(j)){
                    flag = false;
                    break in;
                }else {
                    flag = true;
                }
                if(j == pattern.length() - 1){
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "aaaaaaaaaaaaaab";
        String b = "abc";
        System.out.println(match(a,b));
    }

}
