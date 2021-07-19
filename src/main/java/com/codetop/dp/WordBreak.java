package com.codetop.dp;

import java.util.List;

public class WordBreak {

    /**
     * 思路：
     * 移动字符的下标，确定某一个单词，然后判断wordDict中是否存在该单词
     * @param s
     * @param wordDict
     * @return
     */
    boolean res = true;
    public boolean wordBreak(String s, List<String> wordDict) {

        dfs(s,0,0,wordDict);
        return res;
    }

    private void dfs(String s, int i, int right, List<String> wordDict) {
        if(i == s.length()-1){
            return ;
        }
        /*if(wordDict.contains(s.substring(i,right+1))){
            dfs(s,right+1,);
        }*/
    }
}
