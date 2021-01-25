package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class HasCycle {

    /**
     * 思路为使用一个map去存储每一个节点（对象）
     * 使用putIfAbsent
     * 如果返回！=null，则返回true，存在链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //单节点不能成环
        if(head == null || head.next == null){
            return false;
        }
        Map<ListNode, Integer> map = new HashMap();
        while (head != null) {
            if (map.putIfAbsent(head, 1) != null) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 使用快慢指针：
     * 这种方法的话，需要对龟兔赛跑了解，兔子跑得快，乌龟跑得慢，
     * 如果是链表，那么永远不会相遇
     * 如果是循环链表，那么一定相遇，因为兔子会追上乌龟
     * 回到这个题的话，我们只需要定义快慢指针
     * 快指针每次走两步
     * 慢指针每次走一步
     * 如果两个指针相遇，那么是循环链表
     * 如果不相遇，则是单链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        //因为一个节点无法成环
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {

            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
