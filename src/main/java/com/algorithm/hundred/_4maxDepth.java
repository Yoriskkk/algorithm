package com.algorithm.hundred;

import com.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 */
public class _4maxDepth {

    public int maxDepth(TreeNode node){

        if(node == null){
            return 0;
        }

        int count = 0;
        Queue<TreeNode> stack = new LinkedList();
        stack.add(node);
        while(!stack.isEmpty()){

            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = stack.remove();
                if(remove.left!=null){
                    stack.add(remove.left);
                }
                if(remove.right!=null){
                    stack.add(remove.right);
                }
            }
            count++;

        }
        return count;
    }

}
