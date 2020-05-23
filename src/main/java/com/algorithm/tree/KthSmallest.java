package com.algorithm.tree;

public class KthSmallest {

    static int times = 0;
    static int result = 0;
    public static int kthSmallest(TreeNode root, int k) {

        dfs(root,k);
        return result;
    }

    private static void dfs(TreeNode root, int k) {

        if(root == null){
            return;
        }


        dfs(root.left,k);
        times ++;
        if(times == k){
            result = root.val;
        }
        dfs(root.right,k);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        kthSmallest(treeNode,1);
    }
}
