package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBestAnswer {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null)
            dfs(root, 0);

        return res;
    }

    private void dfs(Node root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList());
        }

        res.get(level).add(root.val);
        for (Node n : root.children) {
            dfs(n, level + 1);
        }
    }

}
