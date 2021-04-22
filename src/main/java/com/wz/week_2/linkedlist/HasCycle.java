package com.wz.week_2.linkedlist;

import com.algorithm.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class HasCycle {

    /**
     * 思路：
     * 1.使用hashmap存放每一个节点
     * 2.使用快慢指针，由于如果有环的话
     *      快指针每次走两步，慢指针每次走一步
     *      if hashCycle 那么一定会相遇
     *      else
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Map<ListNode,String> map = new HashMap<>();
        while(head!=null){
            if(map.get(head)==null){
                map.put(head,"");
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast!=null && slow!=null){

            if(fast == slow){
                return true;
            }
            if(fast.next!=null)
                fast = fast.next.next;
            else
                return false;
            slow = slow.next;
        }

        return false;
    }

}
