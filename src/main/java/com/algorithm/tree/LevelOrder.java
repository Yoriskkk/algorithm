package com.algorithm.tree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 * 1.前中后序遍历的实现一般使用深度优先的方式
 * 2.层序遍历的实现一般使用广度优先的方式
 *
 *
 * 关键点：
 * 1.利用队列先进先出的特性
 * 2.利用队列size敲好是每一层元素的个数
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将二叉树添加到队列中
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                //访问该节点
                list.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            res.add(list);

        }
        return res;
    }

    public void traverse(TreeNode node){

        if(node == null){
            return;
        }
        //访问该节点
        traverse(node.left);
        traverse(node.right);

    }


}
