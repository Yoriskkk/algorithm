package com.algorithm.tree;

public class SortedArrayToBST2 {

    public static TreeNode sortedArrayToBST(int[] nums) {

        //首先找到中间节点坐标 int mid = nums.length/2

        //nums[mid]即为中间节点的值

        return dfs(nums,0,nums.length);

    }

    private static TreeNode dfs(int[] nums, int start, int end) {

        if(start == end){
            return null;
        }
        int mid = end/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums,0,mid);
        node.right = dfs(nums,end/2+1,end);

        return node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(arr);
    }

}
