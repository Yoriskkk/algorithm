package com.geek._06;

import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return ;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
