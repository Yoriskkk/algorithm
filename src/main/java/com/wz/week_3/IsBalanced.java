package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null){
            int level = getLevel(root.right);
            if(level>1){
                return false;
            }
        }else if(root.right == null){
            int level = getLevel(root.left);
            if(level>1){
                return false;
            }
        }else {
            int abs = Math.abs(getLevel(root.left) - getLevel(root.right));
            if (abs>1) {
                return false;
            }
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getLevel(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
        }
        return level;
    }

}
