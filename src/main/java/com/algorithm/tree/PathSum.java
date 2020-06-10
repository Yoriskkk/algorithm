package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> innerList = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root,sum,0);
        return null;
    }

    private void dfs(TreeNode root, int sum ,int start) {

        if(root == null){
            return;
        }

        int result = start + root.val;
        if(result == sum){
            innerList.add(result);


        }


    }

}
