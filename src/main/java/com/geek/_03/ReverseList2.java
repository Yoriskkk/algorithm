package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.List;

public class ReverseList2 {


    /**
     * 这个确实凭空让自己去想比较困难，需要看到别人的解法之后
     * 再思考一下
     * 思路就是
     * 定义pre虚拟头结点，最终返回的就是这个pre指针
     * 定义cur 当前节点指针，一开始的时候指向head
     * while循环中，循环终止条件为cur==null
     * 定义一个temp临时变量存储cur.next,以便最后的时候cur指针往后挪动
     * cur和pre连接上了之后，pre需要指向cur，这样pre就是每一步反转后的链表了
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre; //将当前节点指向pre
            pre = cur; //pre指向cur，下一次当前节点指向pre的时候就是串起来的链表
            cur = temp;
        }
        return pre;
    }

}
