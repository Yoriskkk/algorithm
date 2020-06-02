package com.algorithm.weekgame._185;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1417. 重新格式化字符串 2020.6.2 19.27
 */
public class Reformat {

    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        int numSize = 0;
        int chrSize = 0;
        Queue<Character> queueChr = new LinkedList();
        Queue<Character> queueNum = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            int chr = chars[i];
            if(chr<48 || chr>57){
                chrSize++;
                queueChr.add(chars[i]);
            }else {
                numSize++;
                queueNum.add(chars[i]);
            }
        }
        int result = queueChr.size()-queueNum.size();
        if(result >= 2 || result <= -2){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(result>=0){
            int size = queueChr.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(queueChr.remove());
                if(queueNum.size()!=0){
                    stringBuilder.append(queueNum.remove());
                }

            }
        }else {
            int size = queueChr.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(queueNum.remove());
                if(queueNum.size()!=0){
                    stringBuilder.append(queueChr.remove());
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "a0b1c2";
        reformat(str);

    }

}
