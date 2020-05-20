package com.algorithm.tree;

public class MergeTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }

    private static TreeNode dfs(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode node = null;
        if (t1 == null) {
            node = new TreeNode(t2.val);
            node.left = dfs(null, t2.left);
            node.right = dfs(null, t2.right);
            return node;
        } else if (t2 == null) {
            node = new TreeNode(t1.val);
            node.left = dfs(t1.left, null);
            node.right = dfs(t2.right, null);
            return node;
        } else {
            node = new TreeNode(t1.val + t2.val);
        }
        node.left = dfs(t1.left, t2.left);
        node.right = dfs(t1.right, t2.right);

        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNodeLeft = new TreeNode(1);
        treeNodeLeft.left = new TreeNode(3);
        treeNodeLeft.right = new TreeNode(2);
        treeNodeLeft.left.left = new TreeNode(5);

        TreeNode treeNodeRight = new TreeNode(2);
        treeNodeRight.left = new TreeNode(1);
        treeNodeRight.right = new TreeNode(3);
        treeNodeRight.left.right = new TreeNode(4);
        treeNodeRight.right.right = new TreeNode(7);

        mergeTrees(treeNodeLeft,treeNodeRight);
    }
}
