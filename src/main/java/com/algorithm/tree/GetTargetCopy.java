package com.algorithm.tree;

public class GetTargetCopy {

    public static TreeNode cloneTarget = null;

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        traverse(cloned,target);
        return cloneTarget;

    }

    private static void traverse(TreeNode cloned,TreeNode target) {
        if(cloned == null){
            return;
        }
        if(target.val == cloned.val ){
            cloneTarget = cloned;
        }

        traverse(cloned.left, target);

        traverse(cloned.right, target);

        System.out.println(cloned.val);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(19);
        System.out.println(getTargetCopy(null,treeNode,treeNode.right).val);
    }

}
