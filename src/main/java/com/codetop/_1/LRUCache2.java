package com.codetop._1;

class LRUCache2 {

    private static class DLNode {
        int key, value;
        DLNode prev, next;

        public DLNode() {
        }

        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity, size;
    private DLNode head, tail;
    private DLNode[] cache = new DLNode[3001];

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLNode();
        tail = new DLNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLNode node = cache[key];
        if (node == null) {
            return -1;
        }
        removeNode(node);
        insertNode(node);
        return node.value;
    }

    private void removeNode(DLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNode(DLNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void put(int key, int value) {
        DLNode node = cache[key];
        if (node == null) {
            insertNode(cache[key] = new DLNode(key, value));
            size++;
            if (size > capacity) {
                DLNode last = tail.prev;
                removeNode(last);
                cache[last.key] = null;
                size--;
            }
        } else {
            node.value = value;
            removeNode(node);
            insertNode(node);
        }
    }
}
