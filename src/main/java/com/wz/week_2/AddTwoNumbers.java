package com.wz.week_2;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 思路：
         * 对两个链表的每个节点相加
         *      if sum > 10 下一个节点相加的时候需要+1
         *      else 直接当作当前结果节点的值
         *
         * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
         * 输出：[8,9,9,9,0,0,0,1]
         */

        int count = 0;
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while(l1!=null || l2!=null){
            int val1 = 0;
            if(l1 != null){
                val1 = l1.val;
            }
            int val2 = 0;
            if(l2 != null){
                val2 = l2.val;
            }
            int sum = val1 + val2;
            if(sum>10){
                int i = sum % 10;
                temp.next = new ListNode(i+count);
                count = 1;
            }else {
                if(sum+count>=10){
                    temp.next = new ListNode((sum+count)%10);
                    count =1;
                }else {
                    temp.next = new ListNode(sum+count);
                    count = 0;
                }
            }
            temp = temp.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        if(count == 1){
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    @Test
    public void test(){
        ListNode listNode1 = ListNodeUtil.getListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode listNode2 = ListNodeUtil.getListNode(new int[]{9,9,9,9});
        addTwoNumbers(listNode1,listNode2);

    }
}
