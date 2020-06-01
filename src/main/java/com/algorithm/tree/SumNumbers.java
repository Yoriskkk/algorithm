package com.algorithm.tree;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {

        String sum = dfs(root);
        return Integer.valueOf(sum);
    }

    private String dfs(TreeNode root) {
        if(root == null){
            return "";
        }
        int sum = root.val;
        String strLeft = sum + dfs(root.left);
        String strRight = sum + dfs(root.right);
        return strLeft+strRight;
    }

}
