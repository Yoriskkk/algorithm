package com.wz.week_1;

public class IsPalindrome_9 {

    /**
     * 将数字转换字符串，然后按照之前的回文串进行处理
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //1.如果为负数，直接返回false
        if(x<0){
            return false;
        }
        //2.将数字转换为字符串
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
        }
        return true;
    }

}
