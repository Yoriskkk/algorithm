package com.wz.week_3;

import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {

    public List<Integer> list = new ArrayList<>();
    public int ret;
    public int kthLargest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        kthLargest(root.right,k);
        int val = root.val;
        list.add(val);
        if(k == list.size()){
            ret = val;
            return ret;
        }
        kthLargest(root.left,k);
        return ret;
    }

}
