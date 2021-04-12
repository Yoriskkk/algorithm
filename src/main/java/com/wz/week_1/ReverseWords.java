package com.wz.week_1;

/**
 *
 */
public class ReverseWords {

    /**
     * 思路2：
     * 空间复杂度O(1)
     * 两次reverse
     * 第一次reverse 对整个字符串翻转
     * 第二次reverse将子单词进行翻转
     * @param s
     * @return
     */

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        //对字符串的首尾去掉空格，针对示例2
        s = s.trim();
        //1.首先对字符串做分割处理
        String[] split = s.split(" ");
        //2.对多余空格进行处理
        for (int i = split.length-1; i >=0; i--) {
            if(split[i].contains(" ")){
                split[i] = split[i].replaceAll(" ", "");
            }
            if(split[i].equals("")){
                continue;
            }else {
                if(i!=0){
                    result.append(split[i]+" ");
                }else if(i == 0){
                    result.append(split[i]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String str = "a good   example";
        reverseWords(str);
    }

}
