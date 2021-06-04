package com.wz.week_3;

import com.algorithm.tree.TreeNode;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        return isEqualsVal(root.left,root.right);

    }

    private boolean isEqualsVal(TreeNode left, TreeNode right) {

        if(left == null && right == null){
            return true;
        }
        if(left == null){
            return false;
        }
        if(right == null){
            return false;
        }
        if(left.val == right.val){
            return isEqualsVal(left.left,right.right) && isEqualsVal(left.right,right.left);
        }
        return false;
    }

}
