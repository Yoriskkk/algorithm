package com.codetop._1;

import com.algorithm.list.ListNode;

public class ReverseBetween {

    /**
     * 思路，找到目标链表
     * 然后翻转之后，再和之前的头尾节点连在一起
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        int size = 0;
        //构建虚拟头结点，一般化个例链表
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode temp = result;
        ListNode preLeft = null;
        ListNode afterRight = null;
        ListNode targetListNode = null;
        while(temp!=null){
            if((left-1) == size){
                //找到目标节点的前一个节点
                preLeft = temp;
                ListNode next = temp.next;
                temp.next =null;
                temp = next;
                size++;
                ListNode temp2 = temp;
                //找到需要翻转的链表以及右边界的next节点
                while(temp2!=null){
                    if(size == right){
                        afterRight = temp2.next;
                        temp2.next = null;
                        targetListNode = temp;
                        break;
                    }
                    temp2 = temp2.next;
                    size++;
                }
                break;
            }
            temp = temp.next;
            size++;
        }
        //如果目标链表为空，说明不需要翻转
        if(targetListNode == null){
            return result.next;
        }
        ListNode reverse = reverse(targetListNode);
        preLeft.next = reverse;
        while(reverse.next!=null){
            reverse = reverse.next;
        }
        reverse.next = afterRight;

        return result.next;
    }

    private static ListNode reverse(ListNode targetListNode) {
        ListNode pre = new ListNode(-1);
        while(targetListNode!=null){
            ListNode next = targetListNode.next;
            targetListNode.next = null;
            ListNode preNext = pre.next;
            pre.next = targetListNode;
            pre.next.next = preNext;
            targetListNode = next;
        }
        return pre.next;
    }

    /**
     * 3,5
     * 1
     * 1
     * @param args
     */
    public static void main(String[] args) {

        ListNode node = new ListNode(3);
        node.next = new ListNode(5);
        reverseBetween(node,1,2);
        reverse(node);
    }

}
