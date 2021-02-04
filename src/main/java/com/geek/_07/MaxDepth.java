package com.geek._07;

import com.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {

    /**
     * 思路
     * 使用二叉树的层序遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.remove();
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * 使用dfs，计算最大level数
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        dfs(1,root);
        return sum;
    }
    int sum = 0;
    private void dfs(int i, TreeNode root) {
        if(root == null){
            return;
        }
        if(i>sum){
            sum = i;
        }
        dfs(i+1,root.left);
        dfs(i+1,root.right);
    }
}
