package com.wz.week_1;

/**
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 输入：s = " "
 * 输出：0
 *
 * 输入：s = "Hello app "
 *  * 输出：4
 */
public class LengthOfLastWord {

    /**
     * 思路：
     * 直接从后开始遍历
     * 遇到空格就跳过
     * int length用来对长度进行计数，遇到下一个空格就return
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        int length = 0;
        boolean flag = false;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) == ' ' && flag == true){
                return length;
            }
            if(s.charAt(i) == ' '){
                continue;
            }else {
                flag = true;
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        lengthOfLastWord(s);
    }

}
