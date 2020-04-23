package com.algorithm.list;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //假设两个链表的长度一致，那么一起遍历到一个位置时，就可以获得相同节点
        //假设不一致的，a链表的长度为m，b链表的长度为n，假设m大于n，那么m就先走m-n步

        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {

        /*ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        getKthFromEnd(listNode1,2);*/
    }

}
