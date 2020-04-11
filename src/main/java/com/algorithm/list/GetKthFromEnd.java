package com.algorithm.list;

/**
 * 面试题22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {

    public static ListNode getKthFromEnd(ListNode head, int k) {


        ListNode otherList = head;
        int size1 = 0;
        while (otherList != null) {

            otherList = otherList.next;
            size1++;
        }
        int index = size1 - k;
        int size2 = 0;
        while (index != size2) {

            head = head.next;
            size2++;
        }
        return head;
    }

    /**
     * 解法2：使用快慢指针的思想，快指针先走k步，然后和慢指针一起走，快指针走到末尾（null）,慢指针也就走到了倒数第k个位置
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {


        ListNode fast = head;
        while(fast!=null){
            fast = fast.next;
            if(k == 0){
                head = head.next;
            }else {
                k--;
            }
        }
        return head;
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
        getKthFromEnd(listNode1,2);
    }
}
