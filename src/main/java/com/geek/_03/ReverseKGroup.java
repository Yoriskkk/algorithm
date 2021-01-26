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
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        ListNode result = pre;
        while(method(cur,k)){

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
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {


        return null;
    }

    private static boolean method(ListNode cur, int k) {
        ListNode test =cur;
        for (int i = 0; i <k ; i++) {
            if(test==null){
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
        ListNode listNode = reverseKGroup(head,2);
        System.out.println(listNode);

    }

}
