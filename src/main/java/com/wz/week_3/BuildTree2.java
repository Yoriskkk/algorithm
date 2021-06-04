package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.HashMap;

public class BuildTree2 {

    /**
     * 前序：根->左->右
     * 中序：左->根->右
     * 后续：左->右->根
     *
     * 主要问题：
     * 递归左右子树的时候确认下标
     * @param inorder
     * @param postorder
     * @return
     */
    public static HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return inPostBuildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    private TreeNode inPostBuildTree(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {

        if(in_start > in_end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_end]);
        if(in_start == in_end){
            return root;
        }
        //找到左子树的size
        //根据后续遍历中的根节点的值找到
        Integer in_root_index = map.get(postorder[post_end]);
        int leftTreeSize = in_root_index - in_start;
        root.left = inPostBuildTree(inorder, in_start, in_start+leftTreeSize-1, postorder, post_start, post_start + leftTreeSize - 1);
        root.right = inPostBuildTree(inorder, in_start+leftTreeSize+1, in_end, postorder, post_start+leftTreeSize, post_end-1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{9,3,15,20,7};
        int[] inorder = new int[]{9,15,7,20,3};
//        TreeNode node = buildTree(preorder,inorder);
    }

}
