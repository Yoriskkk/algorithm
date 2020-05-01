package com.algorithm.stack;

import java.util.*;

class MinStack {

    private Stack stack;
    private List minList;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        minList = new ArrayList();
    }
    
    public void push(int x) {
        if(stack.size() == 0){
            min = x;
        }
        stack.push(x);
        min = Math.min(x, min);
        minList.add(min);
    }
    
    public void pop() {
        int pop = (Integer) stack.pop();
        if(pop == min){
            minList.remove(minList.size()-1);
        }
    }
    
    public int top() {
        Object peek = stack.peek();
        return (Integer)stack.peek();
    }
    
    public int min() {
        return (Integer) minList.get(minList.size()-1);
    }
}