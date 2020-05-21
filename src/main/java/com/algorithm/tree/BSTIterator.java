package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {

    private List<Integer> list = new ArrayList();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        dfs(root);

    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        Integer result = list.get(index);
        index++;
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index>=list.size()){
            return false;
        }
        return true;
    }

}
