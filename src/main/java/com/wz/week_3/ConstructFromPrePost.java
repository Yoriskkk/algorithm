package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.HashMap;

public class ConstructFromPrePost {

    //前序 跟->左->右
    //后序 左->右->跟
    public static HashMap<Integer,Integer> postIndexMap = new HashMap<>();
    public static HashMap<Integer,Integer> preIndexMap = new HashMap<>();
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) {
            postIndexMap.put(post[i],i);
        }
        for (int i = 0; i < pre.length; i++) {
            preIndexMap.put(pre[i],i);
        }

        return buildPrePostTree(pre,0,pre.length-1,post,0,post.length-1);

    }

    public static TreeNode buildPrePostTree(int[] pre, int pre_start, int pre_end,int[] post,int post_start,int post_end){

        //终止条件
        if(pre_start > pre_end){
            return null;
        }
        //找到根节点
        TreeNode root = new TreeNode(pre[pre_start]);
        if(pre_start == pre_end){
            return root;
        }
        //找到后续节点中最后一个左子树的节点index
        Integer post_last_left_node_index;
        int leftTreeSize = 0;
        post_last_left_node_index = postIndexMap.get(pre[pre_start]);
        leftTreeSize = post_last_left_node_index - post_start +1;
        //构建左子树
        root.left = buildPrePostTree(pre,pre_start+1,pre_start + leftTreeSize,post,post_start,post_start +leftTreeSize-1);
        //构建右子树
        root.right = buildPrePostTree(pre,pre_start+leftTreeSize+1,pre_end,post,post_start+leftTreeSize ,post_end-1);
        return root;

    }

    //pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] inorder = new int[]{4,5,2,6,7,3,1};
        TreeNode node = constructFromPrePost(preorder,inorder);
    }

}
