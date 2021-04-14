package com.util;

import com.algorithm.list.ListNode;

public class ListNodeUtil {

    public static ListNode getListNode(int[] arr){
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            result.next = node;
            result = result.next;
        }
        return temp.next;
    }

}
