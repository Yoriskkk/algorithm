package com.algorithm.tree;

public class RangeSumBST {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {

        dfs(root,L,R);
        return sum;
    }

    private void dfs(TreeNode root, int L, int R) {
        if(root == null){
            return;
        }
        int val = root.val;
        if(val>=L&&val<=R){
            sum += val;
        }
        dfs(root.left,L,R);
        dfs(root.right,L,R);

    }

}
