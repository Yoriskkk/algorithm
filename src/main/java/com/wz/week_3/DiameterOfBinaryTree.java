package com.wz.week_3;

import com.algorithm.tree.TreeNode;

public class DiameterOfBinaryTree {

    static int res = 0;
    //求二叉树的最大直径
    public static int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return res;

    }

    private static int dfs(TreeNode root) {

        if(root == null){
            return 0;
        }

        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        /**
         * 最大直径转换为求
         * 根节点的最大深度，而根节点的最大深度可以转换
         * 左子树的最大深度+右子树的最大深度
         */
        res = Math.max(l+r,res);

        /**
         * return 是返回当前节点的深度，所以就是左子树和右子树的深度的最大值+自身的节点的深度1
         */
        return Math.max(l,r)+1;

    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        /*node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);*/
        diameterOfBinaryTree(node);
    }

}
