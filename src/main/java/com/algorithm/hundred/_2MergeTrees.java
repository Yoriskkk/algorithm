package com.algorithm.hundred;

import com.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 617.合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并
 * 后的新值，否则不为NULL的节点将直接作为新二叉树的节点。
 */
public class _2MergeTrees {

    /**
     * 思路一：对这两颗树进行遍历，如果两个当前节点都不为null，则相加
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode node;
        if(t1 == null){
            node = new TreeNode(t2.val);
            node.left = dfs(t1,t2.left);
            node.right = dfs(t1,t2.right);
        }else if(t2 == null){
            node = new TreeNode(t1.val);
            node.left = dfs(t1.left,t2);
            node.right = dfs(t1.right,t2);
        }else {
            node = new TreeNode(t1.val+t2.val);
            node.left = dfs(t1.left,t2.left);
            node.right = dfs(t1.right,t2.right);
        }
        return node;
    }

}
