package com.algorithm.tree;

public class CheckSubTree {

    static boolean result = false;
    public static boolean checkSubTree(TreeNode t1, TreeNode t2) {

        dfs(t1,t2);
        return result;
    }

    private static void dfs(TreeNode t1, TreeNode t2) {

        if(t1== null || t2 == null){
            return;
        }

        TreeNode node = new TreeNode(t1.val);
        if(node.val == t2.val){
            result = true;
            dfs(t1.left,t2.left);
            dfs(t1.right,t2.right);
            return;
        }else {
            result = false;
        }
        dfs(t1.left,t2);
        dfs(t1.right,t2);

    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(2);

        checkSubTree(t1,t2);

    }

}
