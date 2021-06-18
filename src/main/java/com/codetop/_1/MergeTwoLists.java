package com.codetop._1;

import com.algorithm.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoLists {

    /**
     * 解法1：暴力法
     * 将两个链表的val收集起来，然后排序
     * 重新new一个链表，然后串连，返回
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while(l1!=null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        for (int i = 0; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return node.next;
    }

    /**
     *  使用两个指针，同时对两个链表遍历
     *  判断val值，然后将其串连
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        while(l1!=null || l2!=null){
            if(l1!=null & l2!=null){
                if(l1.val <= l2.val){
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else {
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }else if(l1 == null){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }else {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }
        return ret.next;
    }

    /**
     *  解法2有一个优化点
     *  如果其中一个链表已经遍历完了
     *  直接接上另外个链表即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val <= l2.val){
                    temp.next = l1;
                    l1 = l1.next;
                }else {
                    temp.next = l2;
                    l2 = l2.next;
                }
            }else if(l1 == null){
                temp.next = l2;
                break;
            }else {
                temp.next = l1;
                break;
            }
            temp = temp.next;
        }
        return ret.next;
    }


}
