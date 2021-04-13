package com.wz.week_2.example;

public class MyLinkedList {

    public class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;

    public Node get(int k) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            int data = temp.data;
            if (data == k)
                return temp;
            i++;
            temp = temp.next;
        }
        return null;
    }

    public Node find(int value) {
        Node temp = head;
        while(temp!=null){
            int data = temp.data;
            if(data ==value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 头部插入
     * @param value
     */
    public void insert1(int value) {
        Node element = new Node(value,null);
        element.next = head;
        head = element;
    }

    /**
     * 尾部插入
     * @param value
     */
    public void insert2(int value) {
        Node element = new Node(value,null);
        if(head == null){
            head = element;
            tail = element;
        }else {
            tail.next = element;
            tail = element;
        }
    }

    /**
     * 在给定结点之后插入元素
     * @param value
     */
    public void insert3(Node target,int value) {
        //遍历当前链表到最后
        //自己的实现
        /*Node temp = head;
        while(temp.next != null){
            if(target == temp){
                break;
            }
            temp = temp.next;
        }
        Node element = new Node(value,null);
        Node tempNext = temp.next;
        temp.next = element;
        element.next = tempNext;*/
        //标准版
        if(target == null){
            return;
        }
        Node newNode = new Node(value,null);
        newNode.next = target.next;
        target.next = newNode;
    }

    /**
     * 删除给定节点之后的节点
     */
    public void delete(Node target) {
        if(target == null || target.next == null){
            return;
        }
        Node temp = target.next;
        target.next = target.next.next;
        temp.next = null;
    }

    /**
     * 删除给定节点
     * 特例需要思考
     * 1.头结点
     * 2.尾节点
     * 3.空链表
     */
    public void delete2(Node target) {
        if(target == null){
            return;
        }
        if(target == head){
            head = head.next;
            return;
        }
        //由于删除target需要知道target前面的一个节点，所以定义一个pre
        Node pre = head;
        while(pre.next!=null){
            if(pre.next == target){
                break;
            }
            pre = pre.next;
        }
        if(pre.next == null){
            return;
        }
        pre.next = pre.next.next;
    }



























}
