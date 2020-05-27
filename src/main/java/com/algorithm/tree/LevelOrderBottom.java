package com.algorithm.tree;

import java.util.*;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size()!=0){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            resultList.add(0,list);

        }
        return resultList;
    }

}
