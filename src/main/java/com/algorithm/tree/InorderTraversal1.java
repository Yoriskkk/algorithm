package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class InorderTraversal1 {
    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        return dfs(root);

    }

    private List<Integer> dfs(TreeNode root) {

        if(root == null){
            return null;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
        return list;
    }

}
