package com.geek._07;

import com.algorithm.tree.TreeNode;

public class IsValidBST {

    private boolean result = true;

    private Integer lastVal = null;
    /**
     * 思路1：
     * 利用二叉搜索树的特点，设置上限和下限，前序遍历时判断当前节点是否在上限节点之间
     * 而上下限节点会在递归过程不断变化
     * 比如递归左节点，那么它的上限就是当前节点的val
     * 递归右节点，那么它下限就是当前节点
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return result;
    }

    private void dfs(TreeNode root,Integer min,Integer max) {
        if (root == null) {
            return;
        }
        if(root.val >= max || root.val <=min){
            result = false;
        }
        dfs(root.left,min,root.val);
        dfs(root.right,root.val,max);
    }

    /**
     * 方法2：
     * 利用中序遍历二叉搜索树的特点，遍历是有序数组
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        dfs2(root);
        return result;
    }

    private void dfs2(TreeNode root) {
        if(root == null) return;
        dfs2(root.left);
        if(lastVal == null){
            lastVal = root.val;
        }else {
            if(root.val<=lastVal){
                result = false;
            }
        }
        lastVal = root.val;
        dfs2(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        order(node);

    }

    private static void order(TreeNode node) {
        if(node == null){
            return;
        }

        order(node.left);
        order(node.right);
        System.out.println(node.val);

    }


}
