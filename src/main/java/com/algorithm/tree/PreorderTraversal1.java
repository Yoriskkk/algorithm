package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreorderTraversal1 {

    public List<Integer> list = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null){
            return Collections.emptyList();
        }
        return dfs(root);
    }

    private List<Integer> dfs(TreeNode root) {

        if(root == null){
            return null;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
        return list;
    }

}
