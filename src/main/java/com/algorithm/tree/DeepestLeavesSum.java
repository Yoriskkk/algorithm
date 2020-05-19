package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum {

    public static int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            //这里的for循环不能使用queue.size，因为在循环过程中会不断的往queue添加元素
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                sum += treeNode.val;
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            System.out.println(sum);
            list.add(sum);
        }
        return list.get(list.size()-1);
    }

    int sum = 0;
    int maxDeep = 0;
    //大神的写法
    public int deepestLeavesSum2(TreeNode root) {

        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int deep) {
        //终止条件
        if(root == null){
            return;
        }
        //if 遍历到了跟节点
        if(root.left == root.right){
            if(deep > maxDeep){
                maxDeep = deep;
                sum = root.val;
            }else if(deep == maxDeep){
                sum += root.val;
            }
        }else {
            dfs(root.left,deep+1);
            dfs(root.right,deep+1);
        }
        //else 没有遍历到跟节点，就继续遍历
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(6);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);
        deepestLeavesSum(treeNode);
    }

}
