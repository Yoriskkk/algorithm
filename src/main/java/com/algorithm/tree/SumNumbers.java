package com.algorithm.tree;

public class SumNumbers {

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int father) {

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

}
