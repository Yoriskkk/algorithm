package com.codetop._1;

import com.algorithm.list.ListNode;

import java.util.HashSet;

public class DetectCycle {

    //使用hash表，将每一个节点进行存储，出现的第一个相同节点就是循环链表的起始节点
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        //找到第一次相遇的地方
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast!=null && slow != null && fast.next!= null && fast!=slow ){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null || fast.next == null || slow == null){
            return null;
        }
        //将fast指针从新指向头节点,找到第二次相遇的地方
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
