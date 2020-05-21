package com.algorithm.tree;

public class SearchBST {

    static boolean flag = false;
    public static TreeNode searchBST(TreeNode root, int val) {

        TreeNode node = dfs(root,val);
        return node;
    }

    private static TreeNode dfs(TreeNode root, int val) {

        if(root == null){
            return null;
        }
        TreeNode node = null;
        if(root.val == val || f){
            node = new TreeNode(root.val);
        }
        if(node == null){
            dfs(root.left,val);
            dfs(root.right,val);
        }else {
            node.left = dfs(root.left,val);
            node.right = dfs(root.right,val);
        }

        return node;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        searchBST(treeNode,2);
    }

}
