package com.codetop._1;

import com.algorithm.list.ListNode;
import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**
         * 注意空参请求
         */
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            LinkedList<Integer> tempList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
                //对于偶数层需要一直加在集合的首部
                if(level%2 == 0){
                    tempList.addFirst(remove.val);
                }else {
                    tempList.add(remove.val);
                }
            }
            result.add(tempList);
        }
        return result;
    }

}
