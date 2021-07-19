package com.codetop._1;

public class NumIslands {

    /**
     * 状态定义
     * dp[i][j] = i,j中，有多少个岛屿
     * dp[i][j] = dp[i-1][j],dp[i][j-1]
     *
     * 选择
     * nums[i][j] 是否为1
     * 是
     *  dp[i][j] = Math.max(dp[i-1][j-1]+1,Math.max(d[i-1][j],dp[i][j-1]))
     *  不为1
     *  dp[i][j] = Math.max(dp[i-1][j-1],Math.max(d[i-1][j],dp[i][j-1]))
     * @param grid
     * @return
     */
    int res = 0;
    public int numIslands(char[][] grid) {

        dfs(grid,0,0);

        return res;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        //终止条件
        if(i >= grid.length || j>= grid[0].length){
            return false;
        }
        boolean down;
        boolean right;
        boolean rightDown;
        if(i< grid.length && j< grid[0].length){
            rightDown = dfs(grid,i+1,j+1);
        }else {
            rightDown = false;
        }

        if(i< grid.length){
            down = dfs(grid,i+1,j);//往下
        }else {
            down = false;
        }



        if(j<grid[0].length){
            right = dfs(grid,i,j+1);//往右
        }else {
            right = false;
        }

        if(grid[i][j] == 0){
            if(down == true || right == true || rightDown =true) {
                res++;
                return true;
            }
            return false;
        }else {
            if(down == false && right == false){
                res ++;
            }
            return true;
        }
    }

}
