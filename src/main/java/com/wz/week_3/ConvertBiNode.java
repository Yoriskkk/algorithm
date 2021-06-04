package com.wz.week_3;

import com.algorithm.tree.TreeNode;

public class ConvertBiNode {

    public TreeNode convertBiNode(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = null;
        root.right = temp;
        convertBiNode(temp);
        convertBiNode(root.right);
        return root;
    }

}
