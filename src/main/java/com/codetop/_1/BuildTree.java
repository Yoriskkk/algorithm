package com.codetop._1;

import com.algorithm.tree.TreeNode;

public class BuildTree {

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if(pre_start > pre_end || pre_start == preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_start]);
        //统计左子树的size，方便对递归的数组进行边界划分
        int leftTreeSize = 0;
        //这里遍历需要参考中序的下标
        for (int i = in_start; i < in_end; i++) {
            if(preorder[pre_start] == inorder[i]){
                break;
            }
            leftTreeSize++;
        }
        root.left = dfs(preorder,pre_start+1,pre_start+leftTreeSize,inorder,in_start,in_start+leftTreeSize-1);
        root.right = dfs(preorder,pre_start+leftTreeSize+1,pre_end,inorder,in_start+leftTreeSize+1,in_end);
        return root;
    }

}
