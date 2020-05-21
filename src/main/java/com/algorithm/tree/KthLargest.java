package com.algorithm.tree;

public class KthLargest {

    static int sum = 0;
    static int result = 0;
    public static int kthLargest(TreeNode root, int k) {

        dfs(root,k);
        return result;
    }

    private static void dfs(TreeNode root, int k) {

        if(root == null){
            return;
        }

        dfs(root.right,k);
        sum ++;
        if(sum == k){
            result = root.val;
        }
        dfs(root.left,k);

    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        kthLargest(treeNode,1);

    }
}
