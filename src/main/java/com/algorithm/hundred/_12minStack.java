package com.algorithm.hundred;

import com.algorithm.list.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 155.最小栈
 * 设计一个支持push，pop，top操作，并能在常数时间内检索到最小元素的栈
 */
public class _12minStack {

    /**
     * 思路1:辅助栈
     * 同时往主栈和辅助栈里push元素，辅助栈栈顶存放最小元素,对push的元素和栈顶的元素做对比，如果小就push，否则不处理
     */
    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public _12minStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    //需要注意的地方，x<=minstack.peek，需要加上=条件，这样在pop的时候，才不会将minStack pop成空栈
    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0 || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if(pop == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        _12minStack minStack = new _12minStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

    }

}
