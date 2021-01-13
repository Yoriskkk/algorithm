package com.algorithm.tree;

public class IsSameTree {

    boolean result = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        return result;
    }

    private void dfs(TreeNode p, TreeNode q) {

        if(p == null){
            if(q != null){
                result = false;
            }
            return;
        }
        if(q == null){
            if(p != null){
                result = false;
            }
            return;
        }
        if(p.val != q.val){
            result = false;
        }
        dfs(p.left,q.left);
        dfs(p.right,q.right);
    }

}
