package com.algorithm.tree;

public class IsUnivalTree {

    boolean result = true;
    public boolean isUnivalTree(TreeNode root) {

        dfs(root,root.val);
        return result;
    }

    private void dfs(TreeNode root,int val) {

        if(root == null){
            return;
        }
        if(root.val != val){
            result = false;
        }
        dfs(root.left,val);
        dfs(root.right,val);

    }

}
