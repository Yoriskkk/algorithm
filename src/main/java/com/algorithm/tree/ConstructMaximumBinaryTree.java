package com.algorithm.tree;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {


        int index = 0;
        TreeNode node = null;
        traverse(node,nums,index);
        return node;
    }

    private void traverse(TreeNode node,int[] nums,int index) {

        if(nums.length == 0){
            return;
        }
        int maxNum = 0;
        index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxNum <= nums[i]){
                index = i;
            }
            maxNum = Math.max(maxNum,nums[i]);
        }
        node = new TreeNode(maxNum);
        if(index>0){
            traverse(node.left,nums,index);
        }
        if(index<nums.length){
            traverse(node.right,nums,index);
        }
    }

}
