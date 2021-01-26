package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.Stack;

public class ReverseKGroup {

    /**
     * 解法1：每k个节点进行链表翻转
     * 使用栈，每k个new 一个stack，进行存放，然后把他们链接起来
     * 该题需要注意的点：
     * 1.while的终止条件，是当前值往后遍历的k个位置都不未null
     * 2.每k个位置进行位置的reverse，剩下的节点，不进行reverse，直接拼上
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        ListNode result = pre;
        while (method(cur, k)) {
            Stack<ListNode> stack = new Stack();
            for (int i = 0; i < k; i++) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < k; i++) {
                ListNode pop = stack.pop();
                pre.next = pop;
                pre = pre.next;
            }
        }
        pre.next = cur;
        return result.next;
    }


    /**
     * 对该题进行最小粒度拆分
     * 分为2步：
     * 1.对每k个节点进行，链表翻转
     * 2.将翻转后的节点进行拼接
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        //定义一个虚拟头节点
        ListNode dummyHead = new ListNode(0);
        //假节点的next指向head
        dummyHead.next = head;
        //初始化pre和end都指向dummyhead
        // pre指每次要翻转的链表的头结点的上一个节点。
        // end指每次要翻转的链表的尾节点
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null) {
            //循环k次，找到需要翻转的链表的结尾，这里每次循环要判断end是否等于空
            for (int i = 0; i < k && end !=null; i++) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            //记录下end.next，方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表，pre.next指向翻转后的链表。1->2变成2->1
            pre.next=reverse(start);
            //翻转后头节点变到最后。通过之前记录的next指针连接起来
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点
            pre = start;
            end = start;
        }


        return dummyHead.next;
    }

    private static ListNode reverse(ListNode start) {
        ListNode pre = null;
        while(start != null){
            ListNode temp = start.next;
            start.next = pre;
            pre = start;
            start = temp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }


    private static boolean method(ListNode cur, int k) {
        ListNode test = cur;
        for (int i = 0; i < k; i++) {
            if (test == null) {
                return false;
            }
            test = test.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseKGroup2(head, 2);
        System.out.println(listNode);

    }

}
