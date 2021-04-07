package com.wz.week_1;

/**
 * 思路：
 * 1.字符串的反转其实就是将前后的字符做一个swap
 *      奇数串，中间位置不用动
 *      偶数串，中间两位做swap
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        //1.奇数串处理
        if(s.length%2 ==1){
            //只对length-1的一半进行swap
            for (int i = 0; i < (s.length - 1)/2; i++) {
                //如果字符相同则不进行swap
                if(s[i] == s[s.length-i-1]){
                    continue;
                }
                swap(i,s.length-i-1,s);
            }
        }else{
            for (int i = 0; i < s.length/2; i++) {
                if(s[i] == s[s.length-i-1]){
                    continue;
                }
                swap(i,s.length-i-1,s);
            }
        }
    }

    private static void swap(int from,int to,char[] chars) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        reverseString(s);
    }

}
