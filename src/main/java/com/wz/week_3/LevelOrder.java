package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        List<List<Integer>> ret = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if(level%2 == 0){
                    tempList.addFirst(remove.val);
                }else {
                    tempList.addLast(remove.val);
                }
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
            ret.add(tempList);
        }
        return ret;
    }
}
