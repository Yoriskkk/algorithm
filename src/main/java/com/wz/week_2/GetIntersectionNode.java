package com.wz.week_2;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.junit.Test;

public class GetIntersectionNode {

    /**
     * 思路：
     * 1.暴力法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headB;
        while (headA != null) {
            while (headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headB = headB.next;
            }
            headB = temp;
            headA = headA.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode A = ListNodeUtil.getListNode(new int[]{4, 1});
        ListNode B = ListNodeUtil.getListNode(new int[]{5, 0, 1});
        ListNode C = ListNodeUtil.getListNode(new int[]{8, 4, 5});
        A.next = C;
        B.next = C;
    }

}
