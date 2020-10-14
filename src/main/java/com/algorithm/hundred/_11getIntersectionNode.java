package com.algorithm.hundred;

import com.algorithm.list.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *  listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
 */
public class _11getIntersectionNode {

    /**
     * 解法一：暴力解法，依次遍历
     * 注意点：在遍历headB的时候，遍历完之后，需要临时变量从新指回headB，不然永远无法进入第二层while循环
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpB = headB;
        while(headA!=null){
            while (tmpB!=null){
                if(headA == tmpB){
                    return headA;
                }
                tmpB = tmpB.next;
            }
            tmpB = headB;
            headA = headA.next;
        }
        return null;
    }

    /**
     * 解法二：哈希表
     * 注意点：在遍历headB的时候，遍历完之后，需要临时变量从新指回headB，不然永远无法进入第二层while循环
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<ListNode, Integer>();
        while(headA!=null){
            map.put(headA,headA.val);
            headA = headA.next;
        }
        while(headB!=null){
            if(map.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 解法三：双指针法
     * 注意点：定义两个指针a,b分别指向headA和headB的头结点，由于总的遍历长度相等即（a+b） = (b+a),所以他们一定会相遇，没有相同结点就会相遇到null上
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            if(a == null){
                a = headB;
            }else {
                a = a.next;
            }
            if(b == null){
                b = headA;
            }else {
                b = b.next;
            }
        }
        return a;
    }



    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(1);
        ListNode commonNode = new ListNode(8);
        node.next.next = commonNode;
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(0);
        node2.next.next = new ListNode(1);
        node2.next.next.next = commonNode;
        getIntersectionNode2(node,node2);
    }

}
