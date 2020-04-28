package com.algorithm.list;

public class DeleteNode {

    public static ListNode deleteNode(ListNode head, int val) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode result = pre;
        while(pre!=null){

            if(pre.next.val == val){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = null;
                break;
            }
            pre = pre.next;
        }

        return result.next;
    }
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        deleteNode(listNode1,1);
    }
}
