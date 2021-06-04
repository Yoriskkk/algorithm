package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.HashMap;

public class BuildTree {
    public static HashMap<Integer,Integer> inorderIndexMap = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i],i);
        }


        return wyyBuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {

        if(p_start == p_end){
            return null;
        }
        //前序遍历的数组的首位就是根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        /**
         * 相当于找到根节点的逻辑是：
         * 前序遍历数组首位 == 中序遍历数组中的index[num]
         * 那么nums左边的 数组就是该根节点的左子树
         * nums右边的 数组就是该根节点的右子树
         */
        int i_root_index = 0;
        for (int i = 0; i < i_end; i++) {
            if(root_val == inorder[i]){
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        //为什么p_end 赋值为p_start+leftNum+1
        root.left = buildTreeHelper(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end);
        return root;
    }

    public static TreeNode myBuildTree(int[] preorder,int i,int j,int[] inorder,int p,int r){

        if (i>j){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        //在中序遍历结果inorder中，查询preorder[i]所在的位置[p,q-1] q [q+1,q]
        int root_index = p;
        while(root_index<=r && inorder[root_index] != preorder[i]){
            root_index++;
        }
        int leftTreeSize = root_index - p;//当前根节点左子树的size
        //构建左子树
        root.left = myBuildTree(preorder,i+1,i+leftTreeSize,inorder,p,root_index-1);
        root.right = myBuildTree(preorder,i+leftTreeSize+1,j,inorder,root_index+1,r);
        return root;
    }

    public static TreeNode wyyBuildTree(int[] preorder,int pre_start,int pre_end,int[] inorder,int in_start,int in_end){
        //终止条件,遍历完了整个数组
        if(pre_start > pre_end){
            return null;
        }
        //找到跟节点
        /**
         * 根节点可以通过前序遍历的首位去找到
         */
        TreeNode root = new TreeNode(preorder[pre_start]);

        //通过前序遍历的首位数，找到在中序遍历的根节点的index
        //该处有一个优化点，对于中序遍历数组，可以提前将其存入map中，取值时就很方便

        /*for (in_root_index = in_start; in_root_index < in_end; in_root_index++) {
            if (preorder[pre_start] == inorder[in_root_index]) {
                break;
            }
        }*/
        int in_root_index = inorderIndexMap.get(preorder[pre_start]);

        //
        int leftTreeSize = in_root_index - in_start;

        //构造左子树
        root.left = wyyBuildTree(preorder,pre_start+1,pre_start+leftTreeSize,inorder,in_start,in_start+leftTreeSize);
        //构造右子树
        root.right = wyyBuildTree(preorder,pre_start+leftTreeSize+1,pre_end,inorder,in_root_index+1,in_end);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode node = buildTree(preorder,inorder);
    }


}
