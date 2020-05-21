package com.algorithm.tree;

public class PruneTree {

    public static TreeNode pruneTree(TreeNode root) {

        return dfs(root);

    }

    private static TreeNode dfs(TreeNode root) {

        if (root == null) {
            return null;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if(root.val == 0 && root.left==null&&root.right==null){
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        pruneTree(treeNode);
    }

}
