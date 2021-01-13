package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //1.申明两个list用来存储两颗数的叶子节点的值
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //2.深度优先遍历两颗树
        dfs(root1,list1);
        dfs(root2,list2);
        //3.添加到list的条件为该节点的左子树和右子树都为null
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        dfs(root.left,list);
        dfs(root.right,list);
    }

}
