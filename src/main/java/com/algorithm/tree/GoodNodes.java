package com.algorithm.tree;

public class GoodNodes {
    /**
     * 注意root的值有可能为负数，所以max的初始值应该赋值为int的最小值而不是0
     */
    static int size = 0;
    public static int goodNodes(TreeNode root) {
        int a = Integer.MIN_VALUE;
        dfs(root,0);
        return size;
    }

    private static void dfs(TreeNode root,int max) {

        if(root == null){
            return;
        }
        max = Math.max(root.val,max);
        if(root.val >= max){
            size++;
        }
        dfs(root.left,max);
        dfs(root.right,max);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.right = new TreeNode(8);
        treeNode.right.right.left = new TreeNode(4);
        goodNodes(treeNode);

    }

}
