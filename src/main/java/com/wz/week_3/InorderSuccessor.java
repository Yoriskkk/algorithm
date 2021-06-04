package com.wz.week_3;

import com.algorithm.tree.TreeNode;

public class InorderSuccessor {


    public boolean flag = false;
    public TreeNode ret;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);
        return ret;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if(root == null){
            return;
        }
        dfs(root.left,p);
        if(ret!=null){
            return;
        }
        if(flag){
            ret = root;
        }
        if(root == p){
            flag = true;
        }
        dfs(root.right,p);
    }

}
