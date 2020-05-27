package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size()!=0){
            Double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                sum += node.val;
            }
            resultList.add(sum/size);
        }
        return resultList;
    }

}
