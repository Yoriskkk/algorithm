package com.wz.week_3;

import com.algorithm.tree.TreeNode;

public class VerifyPostorder {

    public static boolean result = true;

    public static boolean verifyPostorder(int[] postorder) {

        dfs(postorder, 0, postorder.length - 1);

        return result;

    }

    private static void dfs(int[] postorder, int start, int end) {
        //终止条件
        if (start > end) {
            return;
        }

        //判断当前是否满足二叉搜索树
        //找到第一个比根节点大的index,该节点就是根节点的右子树
        int i = start;
        while (postorder[end] > postorder[i]) {
            i++;
        }
        for (int j = i+1; j < end; j++) {
            if (postorder[j] < postorder[end]) {
                result = false;
            }
        }

        int leftTreeSize = i - start;
        dfs(postorder, start, start + leftTreeSize - 1);
        dfs(postorder, start + leftTreeSize, end - 1);
    }

    public static void main(String[] args) {
        /**
         * 输出：
         * false
         * 预期结果：
         * true
         */
        int[] preorder = new int[]{1,2,5,10,6,9,4,3};
        boolean result = verifyPostorder(preorder);
    }

}
