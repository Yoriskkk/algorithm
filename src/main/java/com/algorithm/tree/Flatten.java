package com.algorithm.tree;

public class Flatten {

    public void flatten(TreeNode root) {
        root = dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if(root == null){
            return null;
        }
        root.right = dfs(root.left);
        root.right = dfs(root.right);
        return root;
    }

}
