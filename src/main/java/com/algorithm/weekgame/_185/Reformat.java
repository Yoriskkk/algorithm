package com.algorithm.weekgame._185;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1417. 重新格式化字符串 2020.6.2 19.27
 */
public class Reformat {

    /**
     * 总结：
     * 1.对于数字字符的判断0的asc码是48, 9是57
     * 2.对于尾节点的添加需要判断队列中是否还有值
     * @param s
     * @return
     */
    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        Queue<Character> queueChr = new LinkedList();
        Queue<Character> queueNum = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            int chr = chars[i];
            if(chr<48 || chr>57){
                queueChr.add(chars[i]);
            }else {
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
        String str = "0123456789";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int chr = chars[i];
            System.out.println(chr);
        }

    }

}
