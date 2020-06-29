package com.algorithm.tree;

public class PathSum2 {

    int result = 0;
    public int pathSum(TreeNode root, int sum) {

        dfs(root ,sum,0);
        return result;
    }

    private void dfs(TreeNode root, int sum, int cur) {

        if(root == null){
            return;
        }
        int current = cur + root.val;
        if(current == sum){
            result ++;
        }
        dfs(root.left,sum,current);
        dfs(root.right,sum,current);

    }

}
