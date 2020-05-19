package com.algorithm.tree;

import com.algorithm.list.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {

        //1,层序遍历
        //使用队列的特性，每次remove掉顶层的元素后，添加该节点对应的左子树和右子树
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        List<ListNode> list = new ArrayList<ListNode>();
        while(!queue.isEmpty()){
            ListNode result = new ListNode(-1);
            int size = queue.size();
            ListNode node = result;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                node.next = new ListNode(cur.val);
                node = node.next;
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            list.add(result.next);
        }
        ListNode[] arr = new ListNode[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
