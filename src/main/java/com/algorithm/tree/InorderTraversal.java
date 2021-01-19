package com.algorithm.tree;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    List list = new LinkedList();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
