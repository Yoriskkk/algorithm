package com.wz.week_2.stack;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> minval;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack();
        minval = new Stack();
    }

    /**
     * push的时候，对于data直入
     * 对于minval，需要比较一下，是否比当前的栈顶元素小
     *      如果小于栈顶元素，那么就压入当前值
     *      如果大于，那么就重复压入栈顶元素
     * @param val
     */
    public void push(int val) {
        if(data.isEmpty()){
            data.push(val);
            minval.push(val);
        }else {
            Integer peek = minval.peek();
            if(val < peek){
                minval.push(val);
            }else {
                minval.push(peek);
            }
            data.push(val);
        }
    }

    public void pop() {
        data.pop();
        minval.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minval.peek();
    }

}
