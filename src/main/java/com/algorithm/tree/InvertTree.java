package com.algorithm.tree;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {

        if(root == null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = dfs(root.right);
        node.right = dfs(root.left);
        return node;
    }

}
