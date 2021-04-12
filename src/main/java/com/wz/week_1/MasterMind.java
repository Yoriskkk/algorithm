package com.wz.week_1;

import java.util.HashMap;
import java.util.Map;

public class MasterMind {


    public int[] masterMind(String solution, String guess) {
        int[] result = new int[2];
        int count1 = 0;
        int count2 = 0;
        //找出count1的答案
        Map<String,String> map = new HashMap<>();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if(solution.charAt(i) == guess.charAt(i)){
                count1++;
            }else {
                a.append(solution.charAt(i));
                b.append(guess.charAt(i));
            }
        }
        //找出count2的答案;
        StringBuilder append = a.append(b);
        for (int i = 0; i < append.length(); i++) {
            if(map.get(String.valueOf(append.charAt(i))) == null){
                map.put(String.valueOf(append.charAt(i)),"1");
            }else {
                String s = map.get(String.valueOf(append.charAt(i)));
                if(){

                }
            }
        }
        return result;
    }


    public void test(){

    }

}
