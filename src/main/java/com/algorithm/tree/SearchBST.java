package com.algorithm.tree;

/**
 * 二叉树的遍历思路被限制住，值得反省。
 */
public class SearchBST {
    static boolean flag = false;
    static TreeNode cur = null;
    public static TreeNode searchBST(TreeNode root, int val) {


        TreeNode dfs = dfs(root, val);
        return dfs;
    }

    private static TreeNode dfs(TreeNode root, int val) {

        if(root == null){
            return null;
        }
        if(val < root.val){
            return dfs(root.left,val);
        }
        if(val> root.val){
            return dfs(root.right,val);
        }
        return root;
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
