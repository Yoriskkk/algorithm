package com.algorithm.hundred;

import com.algorithm.list.ListNode;

/**
 * 21.合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _8mergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while(l1!=null || l2!=null){
            if(l1 == null){
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l2 == null){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else if(l1.val < l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        mergeTwoLists(node1,node2);
    }
}
