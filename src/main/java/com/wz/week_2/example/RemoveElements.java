package com.wz.week_2.example;

import com.algorithm.list.ListNode;
import org.junit.Test;

/**
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode result = pre;
        while (pre != null && pre.next != null) {
            ListNode next = pre.next;

            if (next.val == val) {
                //删除temp节点，需要知道temp的前面一个结点
                pre.next = next.next;
            } else {
                pre = pre.next;
            }
        }

        return result.next;

    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode temp = getListNode(arr);
        removeElements(temp.next, 6);
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1};
        ListNode temp = getListNode(arr);
        removeElements(temp.next, 1);
    }

    /**
     * [7,7,7,7]
     * 7
     *
     * @param
     * @return
     */
    @Test
    public void test3() {
        int[] arr = new int[]{7, 7, 7, 7};
        ListNode temp = getListNode(arr);
        removeElements(temp.next, 7);
    }

    private ListNode getListNode(int[] arr) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            result.next = node;
            result = result.next;
        }
        return temp;
    }

}
