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

    /** 0ms耗时 **/
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        if (root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }

}
