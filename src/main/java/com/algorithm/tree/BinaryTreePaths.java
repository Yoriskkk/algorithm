package com.algorithm.tree;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    List<String> list = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root, null);
        return list;
    }

    private void dfs(TreeNode root , String s) {

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(s == null){
                s = String.valueOf(root.val);
            }else {
                s = s + "->" + root.val;
            }
            list.add(s);
        }
        if(s == null){
            s = String.valueOf(root.val);
        }else {
            s = s + "->" + root.val;
        }
        dfs(root.left,s);
        dfs(root.right,s);

    }

}
