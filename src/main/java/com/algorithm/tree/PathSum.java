package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> innerList = new ArrayList();
    int result = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, innerList, sum);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> innerList, int sum) {
        if (root == null) {
            return;
        }
        innerList.add(root.val);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < innerList.size(); i++) {
                result += innerList.get(i);
            }
            if (result == sum) {
                list.add(innerList);
            }
            result = 0;
        }
        List temp = new ArrayList(innerList);
        dfs(root.left, innerList, sum);
        dfs(root.right, temp, sum);
    }
}
