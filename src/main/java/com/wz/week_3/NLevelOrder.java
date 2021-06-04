package com.wz.week_3;

import com.algorithm.tree.Node;
import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {

        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ret = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node remove = queue.remove();
                tempList.add(remove.val);
                List<Node> children = remove.children;
                for (int j = 0; j < children.size(); j++) {
                    if(children.get(j)!=null){
                        queue.add(children.get(j));
                    }
                }
            }
            ret.add(tempList);
        }
        return ret;
    }
}
