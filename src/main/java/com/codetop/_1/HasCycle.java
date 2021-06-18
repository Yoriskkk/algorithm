package com.codetop._1;

import com.algorithm.list.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class HasCycle {

    /**
     * 解法1
     * 遍历这个链表，将其中的节点用hash表存起来？
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        boolean ret = false;
        while(temp!=null){
            if(set.contains(temp)){
                ret = true;
                break;
            }else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return ret;
    }

    /**
     * 解法2：使用快慢指针
     * 如果有环的话，快指针一定会追上慢，如果追上的话，就代表有环
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(slow!=null && fast!=null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }else {
                return false;
            }
        }
        return false;
    }

}
