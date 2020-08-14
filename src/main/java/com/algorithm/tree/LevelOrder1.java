package com.algorithm.tree;

import java.util.*;

public class LevelOrder1 {

    public List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {

        if(root == null){
            return Collections.emptyList();
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size()!=0){
            int size = queue.size();
            List<Integer> innerList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                List<Node> nodeL = node.children;
                if(nodeL !=null){
                    for (int j = 0; j < nodeL.size(); j++) {
                        queue.add(nodeL.get(i));
                    }
                }
                innerList.add(node.val);
            }
            list.add(innerList);
        }

        return list;
    }

    public static void main(String[] args) {

    }

}
