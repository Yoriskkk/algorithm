package com.algorithm.list;

import java.util.Stack;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        Stack<Integer> stack = new Stack();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode result = new ListNode(stack.pop());
        ListNode result2 = result;
        while(!stack.empty()){
            result.next = new ListNode(stack.pop());
            result = result.next;
        }
        return result2;
    }

    /**
     * 双指针解法
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while(cur != null){

            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseList(listNode1);

    }
}
