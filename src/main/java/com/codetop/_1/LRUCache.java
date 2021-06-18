package com.codetop._1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 设计和实现一个LRU cache ,最近最少使用 缓存机制
 * 实现LRUCache类
 *
 *      构造函数 (int capacity) 初始化缓存容量
 *      int get(int key) key对应的value存在则返回缓存值，否则返回-1
 *      void put(int key,int value) if key存在，覆盖；
 *                              else不存在
 *                                  if 容量未满，则直接put
 *                                  else 容量已满，删除最少使用的key，然后再put
 *
 *
 *      要求：需要O(1)的时间复杂度完成get和put操作,get本身借助map就是
 *      put在容量满的情况下，需要找到最远未使用的key，需要使用链表这种结构保证remove的时间复杂度为O(1)
 *          如何找到该key？
 *      如何保证LRU?
 *          使用链表，每次新增的数据，就加在链表尾部，如果重复，就重新将数据放在链表尾部
 *          这样，链表头就是最少使用的数据
 *      为什么链表需要使用双向链表？
 *          因为，链表节点的移动，需要知道该节点的前一个节点，才行，如果不使用双向链表就需要遍历链表才能找到目标节点的前一个节点
 *      如何实现双链表？（一般要求手写）
 *
 *
 *
 */
public class LRUCache {
    private DoubleLinkedList doubleLinkedList;
    private HashMap<Integer, MyNode> map;
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        doubleLinkedList = new DoubleLinkedList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            doubleLinkedList.moveNodeToTail(map.get(key));
            return map.get(key).getValue();
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).setValue(value);
            MyNode tail = doubleLinkedList.moveNodeToTail(map.get(key));
            map.put(key,tail);
        }else {
            if(map.size() == capacity){
                /**
                 * map的删除必须放在前面，不然等链表删除头结点之后，再取头结点，值已经发生了变化
                 */
                map.remove(doubleLinkedList.getHead().key);
                doubleLinkedList.removeNode(doubleLinkedList.getHead());
                MyNode myNode = new MyNode(key, value);
                doubleLinkedList.addTail(myNode);
                map.put(key,myNode);
            }else {
                MyNode myNode = new MyNode(key, value);
                doubleLinkedList.addTail(myNode);
                map.put(key,myNode);
            }
        }
    }
    public class MyNode {
        private MyNode next;
        private MyNode pre;
        public int key;
        public int value;

        public MyNode(int key,int value){
            this.key = key;
            this.value = value;
            next = null;
            pre = null;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }
    }
    public class DoubleLinkedList {

        private MyNode dummyHead;
        private MyNode tail;

        public DoubleLinkedList(){
            dummyHead = new MyNode(-1,-1);
            tail = dummyHead;
        }

        /**
         * 添加节点到链尾
         * @param node
         */
        public void addTail(MyNode node){
            tail.next = node;
            node.pre = tail;
            tail = tail.next;
        }

        /**
         * 获取头结点
         * @return
         */
        public MyNode getHead(){
            return dummyHead.next;
        }

        /**
         * 移除目标节点
         */
        public void removeNode(MyNode node){
            MyNode pre = node.pre;
            MyNode next = node.next;
            if(pre!=null){
                pre.next = next;
            }
            if(next!=null){
                next.pre = pre;
            }else {
                tail = pre;
            }
            node.next = null;
            node.pre = null;
        }

        /**
         * 移动节点到末尾
         */
        public MyNode moveNodeToTail(MyNode node){
            removeNode(node);
            addTail(node);
            return tail;
        }

    }

    /**
     * ["LRUCache","put","get","put","get","get"]
     *  *      [[1],[2,1],[2],[3,2],[2],[3]]
     *
     *  ["LRUCache","put","put","get","put","put","get"]
     * [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
     *
     *
     * ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
     * [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
     *
     *
     * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,-1,null,null,11,null,null,null,null,null,-1,null,null,24,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,-1,null,null,null,24,null,null,null,20,null,null,null,29,-1,-1,null,null,null,null,20,null,null,null,null,null,null,null]
     *
     * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
     *
     * @param args
     */
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(10);
        String[] strarr  =new String[]{"put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        JSONArray objects = JSON.parseArray("[[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]");
        for (int i = 0; i < strarr.length; i++) {
            if(strarr[i].equals("put")){
                cache.put((int)((JSONArray)objects.get(i)).get(0),(int)((JSONArray)objects.get(i)).get(1));
            }else if(strarr[i].equals("get")){
                int i1 = cache.get((int) ((JSONArray) objects.get(i)).get(0));
                if(i1 == 18){
                    System.out.println("....");
                }else {
                    System.out.println(i1);
                }

            }
        }
    }

}
