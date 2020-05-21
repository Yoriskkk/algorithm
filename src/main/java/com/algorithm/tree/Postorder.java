package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {

        dfs(root);
        return list;
    }

    private void dfs(Node root) {
        if(root == null){
            return;
        }
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i));
        }
        list.add(root.val);
        return;
    }

    public static void main(String[] args) {

    }

}
