package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {

    /**
     * 解法1：
     * 使用一个hashmap 存放每次的节点
     * 然后遍历整个链表，如果使用putIfAbsent方法，返回不是null
     * 则代表，该值已经存放过了，链表中有环，反之则为单链表
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        //空节点和单节点无法成环
        if(head == null || head.next == null){
            return head;
        }
        Map<ListNode,Integer> map = new HashMap<>();
        while(head != null){
            if(map.putIfAbsent(head,1)!=null){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 解法2：
     * 同样是使用slow和fast双指针
     * slow走一步，fast走两步
     * 假设环外距离为a，入环点到slow和fast相遇的点的距离为b，slow和fast相遇的点到入环点的距离为c
     * 有这个公式，主要是为了，我们可以推倒出a = c ，在某些情况下
     * 该公式是由fast走过的距离的两种推导方式得出
     * 1.a+n(b+c)+b,环外距离加上n圈距离，再加b
     * 2.2(a+b),fast是slow走的两倍距离
     * 因此a+n(b+c)+b = 2(a+b)
     * 得出a = c+(n-1)(b+c)
     * 所以，我们只需要在slow和fast第一次相遇的时候，定义另外一个指针result
     * result从链表头开始走，slow从slow和fast相遇点开始走
     * 当result和slow相遇的时候，则为入环点
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        //空节点和单节点无法成环
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode result = head;
        while(slow!=null && fast!=null && fast.next!=null){
            if(slow == fast){
                while (result != slow){
                    result = result.next;
                    slow = slow.next;
                }
                return result;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }

}
