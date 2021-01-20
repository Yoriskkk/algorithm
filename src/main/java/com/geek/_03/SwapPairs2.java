package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.Stack;

public class SwapPairs2 {

    /**
     * 使用stack，每次取出两个节点放入stack
     * 再从stack中pop出来
     * 同样也是需要一个虚拟头结点
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        //用stack保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack();
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        head = pre;//最后结果返回的时候返回head.next即可
        while (cur != null && cur.next != null) {

            stack.push(cur);
            stack.push(cur.next);
            cur.next = cur.next.next;
            pre.next = stack.pop();
            pre = pre.next;
            pre.next = stack.pop();
            pre = pre.next;
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 迭代实现
     * 终止条件：当前节点为null，或者下一个节点为null
     * 递归函数要干什么：将2->1, 1->下一层的递归函数，最后返回节点2
     *
     * 原始链表的头结点编程
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs2(temp.next);
        temp.next = head;

        return temp;
    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs3(ListNode head) {
        return head.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs2(head);

    }

}
