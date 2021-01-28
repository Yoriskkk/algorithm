package com.geek._04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.size() == 0){
            minStack.push(x);
        }else {
            if(x< minStack.peek()){
                minStack.push(x);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
