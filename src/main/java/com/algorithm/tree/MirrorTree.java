package com.algorithm.tree;

public class MirrorTree {

    public static TreeNode mirrorTree(TreeNode root) {

        TreeNode node = null;
        node = dfs(root , node);
        return node;
    }

    private static TreeNode dfs(TreeNode root,TreeNode node) {

        if(root == null){
            return null;
        }
        node = new TreeNode(root.val);
        System.out.println(node.val);
        node.left = dfs(root.right,node);
        node.right = dfs(root.left,node);

        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(6);
        mirrorTree(treeNode);
    }
}
