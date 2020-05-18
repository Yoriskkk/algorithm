package com.algorithm.str;


import com.sun.xml.internal.ws.util.StringUtils;

public class ReverseWords {

    public static String reverseWords(String s) {
        //1.对字符串进行按照空格切分
        String[] s1 = s.split(" ");
        //2.对切分后的字符串去掉空格处理
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length-1; i >= 0; i--) {
            if(s1[i].equals("")){
                continue;
            }
            if(i == s1.length-1){
                sb.append(s1[i]);
            }else {
                sb.append(" "+s1[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "  hello world!  ";
        System.out.println(reverseWords(str));
    }

}
