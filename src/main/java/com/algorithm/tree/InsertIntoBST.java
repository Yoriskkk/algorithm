package com.algorithm.tree;

public class InsertIntoBST {
    static boolean flag =true;
    public static TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = dfs(root,val);

        return node;

    }

    private static TreeNode dfs(TreeNode root, int val) {

        if(root == null){
            return null;
        }
        TreeNode node;
        if(val < root.val && flag == true){
            node = new TreeNode(val);

        }else {root.right = new TreeNode(root.val);
            flag = false;
            node = new TreeNode(root.val);
        }
        node.left = dfs(root.left,val);
        node.right = dfs(root.right,val);

        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        insertIntoBST(treeNode,5);
    }

}
