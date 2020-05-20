package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GetAllElements {
    static List<Integer> list = new LinkedList<Integer>();
    static List<Integer> list2 = new LinkedList<Integer>();

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);

        Collections.sort(list);
        return list;
    }

    private static void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

    }

    private static List<Integer> dfs2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {

            dfs2(null,root2.left);
            list.add(root2.val);
            dfs2(null,root2.right);
        } else if (root2 == null) {

            dfs2(root2.left,null);
            list.add(root1.val);
            dfs2(root2.right,null);
        } else {
            dfs2(root1.left,root2.left);
            if(root1.val<=root2.val){
                list.add(root1.val);
                list.add(root2.val);
            }else {
                list.add(root2.val);
                list.add(root1.val);
            }
            dfs2(root1.right,root2.right);
        }


        return list;
    }

    private List<Integer> dfs1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            dfs1(null, root2.left);
            list.add(root2.val);
            dfs1(null, root2.right);
        } else if (root2 == null) {
            dfs1(root1.left, null);
            list.add(root1.val);
            dfs1(root1.right, null);
        } else {
            dfs1(root1.left, root2.left);
            if (root1.val < root2.val) {
                list.add(root1.val);
                dfs1(root1.right, root2);
            } else if (root1.val == root2.val) {
                list.add(root1.val);
                list.add(root1.val);
                dfs1(root1.right, root2.right);
            } else {
                list.add(root2.val);
                dfs1(root1, root2.right);
            }

        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNodeLeft = new TreeNode(2);
        treeNodeLeft.left = new TreeNode(1);
        treeNodeLeft.right = new TreeNode(4);

        TreeNode treeNodeRight = new TreeNode(1);
        treeNodeRight.left = new TreeNode(0);
        treeNodeRight.right = new TreeNode(3);

        getAllElements(treeNodeLeft,treeNodeRight);
    }
}
