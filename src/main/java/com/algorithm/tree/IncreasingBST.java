package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    List<Integer> list = new ArrayList();
    public TreeNode increasingBST(TreeNode root) {

        dfs(root);

        return dfs2(list,0);

    }

    private TreeNode dfs2(List<Integer> list,int index) {

        if(index == list.size()){
            return null;
        }
        TreeNode node = new TreeNode(list.get(index));
        node.right = dfs2(list,index+1);
        return node;

    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

        return;
    }

}
