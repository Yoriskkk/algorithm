package com.algorithm.tree;

import java.util.*;

public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size()!=0){
            int size =queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {

                TreeNode remove = queue.remove();
                if(remove.val>max){
                    max = remove.val;
                }
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
            list.add(max);
        }
        return list;
    }

}
