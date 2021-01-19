package com.geek._03;

import com.algorithm.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 思路1：
 * 1.loop, collect the nums ,reverse
 * 思路2：
 * 1.使用栈数据结构，将元素一个一个往里放，然后往外取的时候，再链接起来
 * 思路3：
 * 1.使用双指针，遍历链表的时候，将当前节点的next指针改为指向前一个元素
 * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改
 * 引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用
 *
 */
public class ReverseList {

    /**
     * 解法一
     * 首先遍历链表，拿到链表中的所有数据，然后放入list中，然后再反序的取，然后放
     * 到链表中
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while(head!=null) {

            int cur = head.val;
            list.add(cur);
            head = head.next;
        }
        ListNode node = new ListNode(list.get(list.size()-1));
        ListNode  result= node;
        for (int i = list.size()-2; i >=0; i--) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return result;
    }

    /**
     * 解法二：
     * 遍历链表，然后将元素放入栈中，往外取的时候，再用链表链接起来
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {

        if(head == null){
            return null;
        }
        Stack<Integer> stack = new Stack();
        while(head!=null) {

            int cur = head.val;
            stack.push(cur);
            head = head.next;
        }

        ListNode node = new ListNode(stack.pop());
        ListNode result = node;
        while(!stack.isEmpty()){
            node.next = new ListNode(stack.pop());
            node = node.next;
        }

        return result;
    }

    /**
     * 解法三：
     * 定义一个prev指针，最好在纸上画一下转变逻辑，就比较容易记忆
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseList2(head);
        System.out.println(listNode);
    }
}
