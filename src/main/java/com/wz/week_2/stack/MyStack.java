package com.wz.week_2.stack;

import java.util.LinkedList;

class MyStack {

    private LinkedList linkedList1;
    private LinkedList linkedList2;

    /** Initialize your data structure here. */
    public MyStack() {
        linkedList1 = new LinkedList();
        linkedList2 = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        linkedList2.push(x);
        while(!linkedList1.isEmpty()){
            linkedList2.offer(linkedList1.poll());
        }
        LinkedList<Integer> temp = linkedList1;
        linkedList1 = linkedList2;
        linkedList2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (int) linkedList1.poll();
    }

    /** Get the top element. */
    public int top() {
        return (int) linkedList1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return linkedList1.isEmpty();
    }
}
