package com.algorithm.tree;

public class SumNumbers {

    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return sum;
    }

    private static void dfs(TreeNode root, int father) {

        if(root == null){
            return;
        }
        int cur = father*10 + root.val;
        if(root.left == null && root.right == null){
            sum +=cur;
            return;
        }
        dfs(root.left,cur);
        dfs(root.right,cur);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        sumNumbers2(treeNode);

    }
































    static int sum2 = 0;
    public static int sumNumbers2(TreeNode root) {

        dfs2(root , new StringBuilder());
        return sum2;

    }

    private static void dfs2(TreeNode root , StringBuilder stringBuilder) {

        if(root == null){
            return;
        }
        StringBuilder temp = stringBuilder.append(root.val);
        if(root.left == null && root.right == null){
            sum2 += Integer.valueOf(stringBuilder.toString());
            return;
        }
//        StringBuilder temp = new StringBuilder(stringBuilder);
        dfs2(root.left,temp);
        dfs2(root.right,temp);
    }


}
