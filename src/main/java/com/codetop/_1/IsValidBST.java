package com.codetop._1;

import com.algorithm.tree.TreeNode;

public class IsValidBST {
    Integer temp = null;
    boolean ret = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return ret;
    }
    private void dfs(TreeNode root) {
        //加上ret == false的判断即可击败100%
        if(root == null || ret == false){
            return ;
        }
        dfs(root.left);
        int cur = root.val;
        if(temp == null){
            temp = cur;
        }else if(cur > temp){
            temp = cur;
        }else {
            ret = false;
        }
        dfs(root.right);
    }
}
