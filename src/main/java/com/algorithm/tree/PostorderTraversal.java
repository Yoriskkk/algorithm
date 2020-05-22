package com.algorithm.tree;

import com.sun.javafx.scene.layout.region.SliceSequenceConverter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

    List list = new LinkedList();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
    }

}
