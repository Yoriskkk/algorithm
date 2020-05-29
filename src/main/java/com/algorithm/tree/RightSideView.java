package com.algorithm.tree;

import java.util.*;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size()!=0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(i == size-1){
                    resultList.add(node.val);
                }
            }
        }
        return resultList;
    }

}
