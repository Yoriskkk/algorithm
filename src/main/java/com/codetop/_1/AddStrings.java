package com.codetop._1;

import org.junit.Test;

public class AddStrings {

    /**
     * 111
     * 1
     * 112
     * 首先计算字符串的值
     *
     * 官方题解，使用i、j两个指针，从两个字符的末尾开始往前遍历
     * 模拟竖式加法
     * 只需要将当前位置的值加起来，再加上进位的值
     * 如果其中某一个数已经遍历完，就使用0代替
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings2(String num1, String num2) {

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder ret = new StringBuilder("");
        while(i>=0 || j>=0){
            int temp = 0;
            if(i<0){
                char num2char = num2.charAt(j);
                temp = ((int)num2char - 48);
            }else if(j <0){
                char num1char = num1.charAt(i);
                temp = ((int)num1char - 48);
            }else {
                char num1char = num1.charAt(i);
                char num2char = num2.charAt(j);
                temp = ((int)num1char - 48) + ((int)num2char - 48);
            }

            if(((temp+carry) / 10) == 1){
//                ret = (temp-10+carry) + ret;
                ret = ret.append((temp-10+carry));
                carry = 1;
            }else {
                ret = ret.append(temp+carry);
//                ret = temp+carry + ret;
                carry = 0;
            }
            i--;
            j--;
        }
        if(carry == 1){
            ret.append(1);
        }

        return ret.reverse().toString();
    }


    public String addStrings(String num1, String num2) {
        long intNum1 = StringToInt(num1);
        long intNum2 = StringToInt(num2);
        long ret = intNum1+intNum2;
        return ret+"";
    }

    private long StringToInt(String num) {
        long ret = 0;
        int length = num.length();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            //因为字符0对应的int值为48
            long temp = (int)c - 48;
            ret = (long) (ret + temp*Math.pow(10,length-1-i));
        }
        return ret;
    }
    @Test
    public void test(){
        String str1 = "456";
        String str2 = "77";
        System.out.println(addStrings2(str1,str2));
    }
    @Test
    public void test2(){
        char a = '0';
        System.out.println((int)a);
    }

}
