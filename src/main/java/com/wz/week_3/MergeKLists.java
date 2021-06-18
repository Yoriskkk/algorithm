package com.wz.week_3;

import com.algorithm.list.ListNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKLists {

    /**
     * 思路1：
     * 暴力法，依次遍历每一个链表，然后将其merge
     * 简单粗暴，遍历所有的链表，将数字存到一个数组里，然后用快速排序，最后再将排序好的数组存到一个链表里。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            //遍历每一个链表
            addNumsToList(lists[i],list);
        }
        Collections.sort(list);
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        for (int i = 0; i < list.size(); i++) {
            ret.next = new ListNode(list.get(i));
        }
        return temp.next;
    }

    private void addNumsToList(ListNode list,ArrayList<Integer> result) {
        while(list!=null){
            result.add(list.val);
            list = list.next;
        }
    }

}
