package com.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    static int sum = 0;
    public static int maxDepth(TreeNode root) {
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
            }
            sum ++;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        maxDepth(treeNode);
    }
}
