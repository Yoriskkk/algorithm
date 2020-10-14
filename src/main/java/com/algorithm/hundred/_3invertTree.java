package com.algorithm.hundred;

import com.algorithm.tree.TreeNode;

/**
 * 226.反转二叉树
 * 翻转一颗二叉树
 */
public class _3invertTree {

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
