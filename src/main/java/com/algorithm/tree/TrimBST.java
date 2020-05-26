package com.algorithm.tree;

public class TrimBST {


    public TreeNode trimBST(TreeNode root, int L, int R) {

        return dfs(root,L,R);

    }

    private TreeNode dfs(TreeNode root, int l, int r) {

        if(root == null){
            return null;
        }
        TreeNode node = null;
        if(root.val>=l&&root.val<=r){
            node = new TreeNode(root.val);
        }
        dfs(root.left,l,r);
        dfs(root.right,l,r);

        return node;
    }

}
