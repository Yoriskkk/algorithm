package com.algorithm.tree;

public class RemoveLeafNodes {

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root,target);
    }

    private static TreeNode dfs(TreeNode root, int target) {
        if(root == null){
            return null;
        }

        TreeNode node = new TreeNode(root.val);

        node.left = dfs(root.left,target);
        node.right = dfs(root.right,target);
        System.out.println(root.val);
        if(node.val == target && node.left == null && node.right == null){
            return null;
        }

        return node;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        removeLeafNodes(treeNode,3);
    }
}
