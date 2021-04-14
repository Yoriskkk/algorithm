package com.wz.week_2;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

/**
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class GetKthFromEnd {

    /**
     * 遍历到末尾，获取链表的size
     * size - k = index
     * 再次遍历，i从0开始，一致遍历到i=index
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        int index = length - k;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    @Test
    public void test(){
        ListNode listNode = ListNodeUtil.getListNode(new int[]{1, 2, 3, 4, 5});
        getKthFromEnd(listNode,2);
    }

}
