package com.wz.week_1;


import org.junit.Test;

/**
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    /**
     * 思路：
     * new 一个StringBuilder然后对s字符串进行遍历，遇到空格就变成%20append在StringBuilder后面
     * @param
     * @return
     */
    public String replaceSpace(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        String s ="We are happy.";
        replaceSpace(s);
    }
}
