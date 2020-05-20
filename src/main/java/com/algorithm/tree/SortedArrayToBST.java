package com.algorithm.tree;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {

        //平衡二叉树的定义，左边的所有节点都小于根节点，右边的所有节点都大于根节点
        TreeNode node= dfs(nums,0,nums.length-1);
        return node;
    }

    private static TreeNode dfs(int[] nums,int left,int right) {

        if(left > right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        System.out.println(node.val);
        node.left = dfs(nums,left,mid - 1);
        node.right = dfs(nums,mid+1,right);
        return node;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(arr);

    }

}
