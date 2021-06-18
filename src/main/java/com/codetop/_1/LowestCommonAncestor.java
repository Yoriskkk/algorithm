package com.codetop._1;

import com.algorithm.tree.TreeNode;

public class LowestCommonAncestor {

    TreeNode ret = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件
        contains(root,p,q);
        return ret;
    }

    private int contains(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        //终止条件

        int leftContains = contains(root.left, p, q);
        int rightContains = contains(root.right, p, q);
        int rootContains = 0;
        //root本身为p或q
        if(root == p || root == q){
            rootContains = 1;
            if(leftContains==1 || rightContains==1){
                ret = root;
            }
        }else {
            //root的左右子树分别包含一个p或q
            if(leftContains == 1 && rightContains == 1){
                ret = root;
            }
        }

        return leftContains+rightContains+rootContains;
    }

}
