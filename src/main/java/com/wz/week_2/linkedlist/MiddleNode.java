package com.wz.week_2.linkedlist;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

/**
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 */
public class MiddleNode {
    /**
     * 思路：
     * 需要找中间位置
     * 获取到总的size,hou
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        int mid = size/2;
        for (int i = 0; i < mid; i++) {
            head = head.next;
        }
        return head;
    }

    @Test
    public void test(){
        ListNode listNode = ListNodeUtil.getListNode(new int[]{1, 2, 3, 4, 5});
        middleNode(listNode);
    }


}
