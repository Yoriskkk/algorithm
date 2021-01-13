package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostOrder1 {

    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return Collections.emptyList();
        }
        return dfs(root);

    }

    private List<Integer> dfs(Node root) {

        if(root == null){
            return null;
        }
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i));
            list.add(root.val);
        }
        return list;
    }

}
