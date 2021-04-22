package com.wz.week_2.linkedlist;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

public class RemoveNthFromEnd {

    /**
     * 思路：
     * 第一次遍历链表，找到倒数第n个节点
     * 并且获取链表的长度length
     * length - n = index
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        int index = length - n;
        if(length ==1 && index == 0){
            return null;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        if(index == 0){
            result.next = head.next;
        }
        return result.next;
    }

    /**
     * 方法2：快慢双指针，让快指针先走n步
     * 为了兼容删除头结点的逻辑，我们使用虚拟头节点
     * 让slow和fast同时从虚拟头节点出发
     * 在图纸上将整个画一遍即可解决
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        ListNode slow = pre;
        ListNode fast = pre;
        pre.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }

    @Test
    public void test(){
        ListNode listNode = ListNodeUtil.getListNode(new int[]{1, 2});
        removeNthFromEnd2(listNode,2);
    }

}
