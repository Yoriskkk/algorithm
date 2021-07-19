package com.codetop.dp;

import java.util.List;

public class MinimumTotal {

    /**
     * 要求最小路径和
     * f(n) = f(n-1) + MinNum
     * @param triangle
     * @return
     */
    public int ret = Integer.MIN_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        int i = 0;
        int j = 0;

        return dfs(triangle,i,j);


    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {

        if(i > triangle.size()){
            return 0;
        }
        if(j > triangle.get(i).size()){
            return 0;
        }
        for (int k = 0; k < j; k++) {
            int dfs = dfs(triangle, i, k);
        }
        List<Integer> list = triangle.get(i);
        Integer temp = list.get(j);
        ret = Math.max(ret,temp);
        return dfs(triangle,i+1,j);

    }

}
