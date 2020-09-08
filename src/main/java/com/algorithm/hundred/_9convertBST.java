package com.algorithm.hundred;

import com.algorithm.list.ListNode;
import com.algorithm.tree.TreeNode;

/**
 * 538.把二叉搜索树转换成为累加树
 * 给定一个二叉搜索树，把它转换成为累加树，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class _9convertBST {

    static int temp = 0;
    public static TreeNode convertBST(TreeNode root) {
        return dfs(root);
    }

    private static TreeNode dfs(TreeNode node) {

        if(node == null){
            return null;
        }

        dfs(node.right);
        int curr = node.val;
        temp +=curr;
        node.val = temp;
        dfs(node.left);
        System.out.println(node.val);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        convertBST(root);
    }

}
