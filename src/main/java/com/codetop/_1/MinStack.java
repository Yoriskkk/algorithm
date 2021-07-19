package com.codetop._1;

import java.util.Stack;

/**
 * 定义两个 stack
 */
public class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.size() == 0){
            stack2.push(val);
        }else {
            if(val < stack2.peek()){
                stack2.push(val);
            }else {
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

}
