package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder3 {

    List<Integer> list = new ArrayList<Integer>();
    public int[] levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size()!=0){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
                list.add(remove.val);
            }

        }

        Object[] objects = list.toArray();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = (Integer) objects[i];
        }
        return result;
    }


}
