package com.algorithm.list;

/**
 * 面试题25. 合并两个排序的链表
 */
public class MergeTwoLists {

    /**
     * 大致思路：
     * 1.双指针，同时遍历两个链表
     * 如果l1的val <= l2.val
     * 则赋值另外声明的链表当前节点
     * 如果一开始想不出来，可以在纸一步一步的把步骤画出来
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while(l1 != null && l2 != null){

            if(l1.val <= l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }
        if (l2 == null){
            cur.next = l1;
        }
        return temp.next;



    }
}
