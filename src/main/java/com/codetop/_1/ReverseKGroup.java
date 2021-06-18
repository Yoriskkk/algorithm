package com.codetop._1;

import com.algorithm.list.ListNode;

public class ReverseKGroup {

    /**
     * 只需要对每k个一组的子链表，进行翻转链表
     * 但是需要注意，翻转后的链表，是需要接起来的
     * <p>
     * 遍历整个链表
     * 遍历k个之后，获取子链表，如果不足k个即不翻转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        while(end!=null){
            //找到k组子串的末尾
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverseListNode(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummyHead.next;

    }

    /**
     * 翻转链表
     * 将pre的指针，逐渐形成翻转后的链表
     * 1.声明一个pre指针 ，指向null
     * 2.对head（目标链表）进行遍历，终止条件为head！=null
     * 1.首先取得head.next链表，因为下一步，head将会指向其他地址
     * 2.将head.next指向pre,从这里开始，head就和原链表分开了
     * 3.pre重新指向head,以便下一次
     * 4.head需要往下继续遍历，将其指向之前存的next节点
     *
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
