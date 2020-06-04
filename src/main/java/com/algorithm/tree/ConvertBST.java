package com.algorithm.tree;

public class ConvertBST {

    static int sum  = 0;
    public static TreeNode convertBST(TreeNode root) {
        return dfs(root);
    }

    private static TreeNode dfs(TreeNode root) {
        if(root == null){
            return null;
        }

        dfs(root.right);

        sum += root.val;
        root.val = sum;
        dfs(root.left);

        return root;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(13);
        convertBST(node);
    }

}
