package com.algorithm.tree;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    List<String> list = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root, new StringBuilder());
        return list;
    }

    private void dfs(TreeNode root , StringBuilder s) {

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(s.length() == 0){
                s.append(root.val);
            }else {
                s.append("->").append(root.val);
            }
            list.add(s.toString());
        }
        if(s.length() == 0){
            s.append(root.val);
        }else {
            s.append("->").append(root.val);
        }
        StringBuilder temp = new StringBuilder(s);
        dfs(root.left,s);
        dfs(root.right,temp);

    }

}
