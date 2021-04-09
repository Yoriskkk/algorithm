package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class StrToInt {

    /**
     * 使用map存入0~9以及-
     * 遍历字符串的时候，使用map.get();
     * 使用StringBuilder存放结果值
     * 有值：
     *  遇到+或者-号，后面的值必须是数字
     *  遇到空格就continue
     * @param str
     * @return
     */
    public int strToInt(String str) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), "");
        }
        map2.put("+","");
        map2.put("-","");
        map2.put(" ","");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(map2.get(String.valueOf(str.charAt(i)))==null && map.get(String.valueOf(str.charAt(i)))==null){
                return 0;
            }

            if(str.charAt(i) == '+'){
                if(i+1<str.length() ){
                    if(str.charAt(i+1) == '-'){
                        return 0;
                    }
                    if(map.get(String.valueOf(str.charAt(i+1))) == null){
                        return 0;
                    }
                }
            }

            if(str.charAt(i) == '-'){
                if(i+1<str.length() ){
                    if(str.charAt(i+1) == '+'){
                        return 0;
                    }
                    if(map.get(String.valueOf(str.charAt(i+1)))!=null){
                        stringBuilder.append("-");
                    }else {
                        return 0;
                    }
                }
            }
            if(map.get(String.valueOf(str.charAt(i)))!=null){
                while(i<str.length() && map.get(String.valueOf(str.charAt(i)))!=null){
                    stringBuilder.append(str.charAt(i));
                    i++;
                }
                break;
            }
        }

        if(stringBuilder.toString().isEmpty()){
            return 0;
        }
        BigInteger result = new BigInteger(stringBuilder.toString());
        if (result.compareTo(BigInteger.valueOf(Long.valueOf("-2147483648"))) <= 0) {
            return Integer.MIN_VALUE;
        }
        if (result.compareTo(BigInteger.valueOf(Long.valueOf("2147483647")))>0) {
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(String.valueOf(result));
    }

    @Test
    public void test(){
        String str = "  +  413";
        Assert.assertEquals(strToInt(str),0);
    }

}
