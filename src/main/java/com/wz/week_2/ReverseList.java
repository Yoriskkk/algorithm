package com.wz.week_2;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

public class ReverseList {

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 思路：
     * 使用一个pre 指向head
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while(head!=null){
            ListNode temp = head.next;
            ListNode next = pre.next;
            pre.next = head;
            head.next = null;
            head = temp;
            pre.next.next = next;
        }
        return result.next;
    }

    @Test
    public void test(){
        ListNode node = ListNodeUtil.getListNode(new int[]{1,2,3,4,5});
        reverseList(node);
    }


}
