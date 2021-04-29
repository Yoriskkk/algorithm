package com.wz.week_2;

import java.util.Stack;

class CQueue {

    /**
     * appendTail 和 deleteHead
     * 思路：
     * 使用两个stack
     */
    private Stack<Integer> orderStack;
    private Stack<Integer> reverseStack;

    public CQueue() {
        this.orderStack = new Stack();
        this.reverseStack = new Stack();
    }

    public void appendTail(int value) {
        if (orderStack == null){
            return ;
        }
        orderStack.push(value);
    }

    public int deleteHead() {
        if(reverseStack == null){
            return -1;
        }
        if(reverseStack.isEmpty()){
            if(orderStack.isEmpty()){
               return -1;
            }
            while(!orderStack.isEmpty()){
                reverseStack.push(orderStack.pop());
            }
        }
        return reverseStack.pop();
    }
}
