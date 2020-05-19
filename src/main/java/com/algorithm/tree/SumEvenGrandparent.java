package com.algorithm.tree;

public class SumEvenGrandparent {

    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.val%2 ==0){
            if(root.left!=null){
                getSum(root.left);
            }
            if(root.right!=null){
                getSum(root.right);
            }
        }
        dfs(root.left);
        dfs(root.right);
    }

    private void getSum(TreeNode left) {
        if(left.left!=null){
            sum+=left.left.val;
        }
        if(left.right!=null){
            sum+=left.right.val;
        }
    }


}
