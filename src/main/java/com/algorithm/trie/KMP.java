package com.algorithm.trie;

public class KMP {

    /**
     *
     * @param mainStr 主串
     * @param mainStrLength 主串长度
     * @param pattern 模式串
     * @param patternLength 模式串长度
     * @return
     */
    public static int kmp(char[] mainStr,int mainStrLength,char[] pattern,int patternLength){

        int[] next = getNexts(pattern,patternLength);
        int j = 0;
        for (int i = 0; i < mainStrLength; i++) {
            while(j>0 && mainStr[i] != pattern[j]){
                j = next[j - 1] + 1;
            }
            if(mainStr[i] == pattern[j]){
                ++j;
            }
            if(j == patternLength){//找到匹配模式串了
                return i-patternLength+1;
            }
        }
        return -1;
    }

    public static int[] getNexts(char[] pattern,int patternLength){
        int[] next = new int[patternLength];
        next[0] = -1;
        int k = -1;
        for (int i = 0; i < patternLength; i++) {
            while(k!=-1 && pattern[k+1] != pattern[i]){
                k = next[k];
            }
            if(pattern[k+1] == pattern[i]){
                ++k;
            }
            next[i]=k;
        }
        return next;
    }
}
