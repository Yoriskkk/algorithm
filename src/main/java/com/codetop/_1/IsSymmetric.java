package com.codetop._1;

import com.algorithm.tree.TreeNode;
import com.google.gson.internal.$Gson$Preconditions;

public class IsSymmetric {

    /**
     * 判断二叉树是否为对称二叉树
     * 左右节点是堆成的
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
