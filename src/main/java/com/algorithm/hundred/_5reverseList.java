package com.algorithm.hundred;

import com.algorithm.list.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 206.反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class _5reverseList {

    public ListNode reverseList1(ListNode head){

        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;

    }

    public static ListNode reverseList2(ListNode head){

        ListNode newHead = null;
        while(head!=null){

            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;

    }



    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reverseList2(node);
    }

}
