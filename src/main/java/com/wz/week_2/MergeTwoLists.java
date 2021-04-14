package com.wz.week_2;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

public class MergeTwoLists {

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * [5]
     * [1,2,4]
     * 遍历到两个链表的尾部
     * 需要注意该种情况，有可能某一个步骤，链表并部需要往后遍历
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val>l2.val){
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                }else {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                }
            }else {
                int val = 0;
                if(l1 == null){
                    val = l2.val;
                    l2 = l2.next;
                }else if(l2 == null){
                    val = l1.val;
                    l1 = l1.next;
                }
                temp.next = new ListNode(val);
                temp = temp.next;
            }

        }
        return result.next;
    }

    @Test
    public void test(){
        ListNode node1 = ListNodeUtil.getListNode(new int[]{5});
        ListNode node2 = ListNodeUtil.getListNode(new int[]{1,2,4});
        mergeTwoLists(node1,node2);
    }

}
