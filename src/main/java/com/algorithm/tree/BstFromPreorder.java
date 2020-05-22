package com.algorithm.tree;

public class BstFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {

        return dfs(preorder,0,preorder.length);

    }

    private TreeNode dfs(int[] preorder, int start, int length) {

        return null;

    }

}
