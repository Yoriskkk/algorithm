package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {

        if(root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);

    }

}
