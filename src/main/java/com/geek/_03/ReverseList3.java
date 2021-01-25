package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.Stack;

public class ReverseList3 {


    /**
     * 使用pre指针，首先指向null
     * 然后定义一个cur指针指向head
     * 循环终止条件为cur == null
     * 使用一个temp记录cur.next，因为cur等等指向了pre之后，就不能往后挪了
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }

    /**
     * 使用stack数据结构，存进去，再取出来就是我们想要的结果了
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (stack.size() != 0) {

            Integer pop = stack.pop();
            cur.next = new ListNode(pop);
            cur = cur.next;
        }
        return result.next;

    }

}
