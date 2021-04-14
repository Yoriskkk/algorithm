package com.wz.week_2;

import com.algorithm.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class HasCycle {

    /**
     * 思路：
     * 1.使用hashmap存放每一个节点
     * 2.使用快慢指针，由于如果
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

        if(){

        }


        return false;
    }

}
