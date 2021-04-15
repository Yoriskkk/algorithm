package com.wz.week_2;

import com.algorithm.list.ListNode;
import com.util.ListNodeUtil;
import org.apache.dubbo.qos.command.impl.Ls;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    /**
     * 输入: 1->2
     * 输出: false
     * 输入: 1->2->2->1
     * 输出: true
     * 思路：
     * 1.使用栈？对每一个元素依次放入stack中，
     * 2.将链表转换为数组？然后双指针判断？
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int size = 0;
        while (head != null) {
            size++;
            list.add(head.val);
            head = head.next;
        }
        if (size == 1) {
            return true;
        }
        int right = size - 1;
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(right)) {
                return false;
            }
            right--;
        }

        return true;
    }


    /**
     * 思路：
     * 1.使用快慢指针
     * 快指针先走到末尾，然后慢指针的节点反转，然后再与满指针.next的节点进行比较
     * 如果快指针
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while(fast!=null&&fast.next!=null){
            //对前面的链表进行翻转
            fast = fast.next.next;
            ListNode next = slow.next;
            ListNode next1 = pre.next;
            pre.next = slow;
            pre.next.next = next1;
            slow = next;
        }
        ListNode temp = null;
        ListNode next = null;
        if(fast == null){
            temp = slow;
            next = slow.next;
            reverse(temp);
        }else {
            temp = slow;
            next = slow;
            reverse(temp);
        }
        while(temp!=null){
            if(temp.val != next.val){
                return false;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while(head!=null){
            ListNode temp = head.next;
            ListNode next = pre.next;
            pre.next = head;
            pre.next.next = next;
            head = temp;
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode listNode = ListNodeUtil.getListNode(new int[]{1, 0, 1});
        isPalindrome2(listNode);
    }

    @Test
    public void test2(){
        ListNode listNode = ListNodeUtil.getListNode(new int[]{1, 0});
        reverse(listNode);
    }

}
