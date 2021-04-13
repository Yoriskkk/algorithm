package com.wz.week_2;

import com.algorithm.list.ListNode;

public class DeleteDuplicates {

    /**
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     *
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while(temp.next!=null){
            ListNode next = temp.next;
            if(temp.val == next.val){
                temp.next = next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;

    }

}
