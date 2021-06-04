package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum {

    static List<List<Integer>> result = new ArrayList<>();
    static int sum = 0;
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target,new ArrayList<Integer>());
        return result;
    }

    /**
     * 如何保证底部的左右子树一次只被加入一次到templist中?
     * @param root
     * @param target
     * @param integers
     */
    private static void dfs(TreeNode root, int target, List<Integer> integers) {
        if(root == null){
            return;
        }
        integers.add(root.val);
        /**
         * 该处遍历可以优化
         */
        sum += root.val;
        if(sum == target){
            if(root.left==null && root.right == null){
                result.add(new ArrayList<>(integers));
            }
        }
        dfs(root.left,target,integers);
        dfs(root.right,target,integers);
        /**
         * 在处理完一轮后，将list中最后一个元素进行清除，即可达到上诉效果
         */
        sum -= integers.get(integers.size()-1);
        integers.remove(integers.size()-1);

    }

    public static void main(String[] args) {
        /**
         *               5
         *              / \
         *             4   8
         *            /   / \
         *           11  13  4
         *          /  \    / \
         *         7    2  5   1
         */
        /*TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);*/
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        pathSum(node,1);
    }
}
