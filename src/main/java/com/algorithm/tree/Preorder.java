package com.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<Integer>();
        dfs(root,list);
        return list;
    }

    private void dfs(Node root, List<Integer> list) {

        if (root == null)
            return;

        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {

            dfs(root.children.get(i),list);

        }

    }

}
