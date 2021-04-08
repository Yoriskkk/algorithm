package com.wz.week_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StrToInt {

    /**
     * 使用map存入0~9以及-
     * 遍历字符串的时候，使用map.get();
     * 使用StringBuilder存放结果值
     * 有值：
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        Map<String, String> map = new HashMap<>();
        map.put("-", "");
        map.put("+", "");
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), "");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

        }

        if(stringBuilder.toString().isEmpty() || stringBuilder.toString().equals("-")){
            return 0;
        }
        Long result = Long.valueOf(stringBuilder.toString());
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(String.valueOf(result));
    }

    @Test
    public void test(){
        String str = "   +0 123";
        Assert.assertEquals(strToInt(str),123);
    }

}
