package com.algorithm.hundred;

import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 101.对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的
 */
public class _13isSymmetric {

    public static boolean isSymmetric(TreeNode root) {

        return dfs(root,root);

    }

    /**
     * 解题思路，传入两个节点，分别从左边和右边开始遍历
     * @param left
     * @param right
     * @return
     */
    private static boolean dfs(TreeNode left, TreeNode right) {

        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = null;
        node.left.right = new TreeNode(3);
        node.right.left = null;
        node.right.right = new TreeNode(3);
        isSymmetric(node);
    }



}
