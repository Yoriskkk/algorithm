package com.wz.week_3;

import com.algorithm.tree.Node;

public class MaxDepth {

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < root.children.size(); i++) {
            result = Math.max(result,maxDepth(root.children.get(i)));
        }
        return result + 1;
    }

}
