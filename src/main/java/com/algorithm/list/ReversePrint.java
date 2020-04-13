package com.algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题06. 从尾到头打印链表
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList();
        while(head != null){
            list.add(0,head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
