package com.algorithm.tree;

import java.util.*;

public class LevelOrder2 {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(queue.size()!=0){

            int size = queue.size();
            List<Integer> inList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {

                Node node = queue.remove();
                List<Node> list = node.children;
                if(list!=null){
                    for (int j = 0; j < list.size(); j++) {
                        queue.add(node.children.get(j));
                    }
                }
                inList.add(node.val);

            }
            resultList.add(inList);

        }
        return resultList;
    }

}
