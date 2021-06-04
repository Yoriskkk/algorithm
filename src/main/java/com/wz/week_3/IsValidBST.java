package com.wz.week_3;

import com.algorithm.tree.TreeNode;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int val = root.val;
        if(isValidBST(root.left) && isValidBST(root.right) && method(root.right,val)){
            if(root.left == null){
                if(root.right.val>val){
                    return true;
                }else {
                    return false;
                }
            }else if(root.right == null){
                if(root.left.val < val){
                    return true;
                }else {
                    return false;
                }
            }
            if(root.left.val < val && root.right.val>val){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    private boolean method(TreeNode right,Integer val) {
        if(right == null){
            return true;
        }
        if(val >= right.val){
            return false;
        }
        return method(right.left,val) && method(right.right,val);
    }

}
