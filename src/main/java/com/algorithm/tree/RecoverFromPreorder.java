package com.algorithm.tree;

public class RecoverFromPreorder {

    public TreeNode recoverFromPreorder(String S) {

        String[] split = S.split("-");

        return dfs(split,0);

    }

    private TreeNode dfs(String[] split,int size) {

        if(split[size] .equals("") || size == split.length){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(split[size]));
        node.left = dfs(split,++size);
        node.right = dfs(split,++size);
        return node;
    }

}
