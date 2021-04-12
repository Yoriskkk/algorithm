package com.wz.week_2.example;

/**
 * 实现头插、尾插、根据索引插入、根据索引删除、tostring打印
 */
public class LinkedList2 {

    public class Node{
        private int value;
        private Node pre;
        private Node next;
        public Node(int value,Node next,Node pre){
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    private Node head = null;
    /**
     * 头插
     */
    public void addFirst(Node target){

        Node temp = head;
        temp.pre.next = target;
        target.next = temp;
        head = temp;

    }




}
