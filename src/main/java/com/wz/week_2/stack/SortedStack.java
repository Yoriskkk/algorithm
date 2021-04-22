package com.wz.week_2.stack;

import java.util.Stack;

public class SortedStack {

    private Stack<Integer> minStack;
    private Stack<Integer> temp;

    public SortedStack() {
        minStack = new Stack();
        temp = new Stack<>();
    }

    public void push(int val) {
        minStack.push(val);
    }

    /**
     * 使用一个最小值int min ，记录栈中的最小值
     * 针对重复元素的情况，可能会删除掉两个元素，定义一个falg，保证一次pop
     * 只删除一个元素
     */
    public void pop() {
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        //遍历minstack，找到栈中的最小值，并将所有的元素pop到temp中
        while(!minStack.isEmpty()){
            int pop = minStack.pop();
            min = Math.min(pop,min);
            temp.push(pop);
        }
        //遍历temp,找到最小值，然后将其余的数重新push到minstack中
        while(!temp.isEmpty()){
            int pop = temp.pop();
            if(pop == min && flag == false){
                flag = true;
                continue;
            }
            minStack.push(pop);
        }
    }

    public int peek() {
        int min = Integer.MAX_VALUE;
        if(minStack.isEmpty()){
            return -1;
        }
        while(!minStack.isEmpty()){
            int pop = minStack.pop();
            min = Math.min(pop,min);
            temp.push(pop);
        }
        while(!temp.isEmpty()){
            int pop = temp.pop();
            minStack.push(pop);
        }
        return min;
    }

    public boolean isEmpty() {
        return minStack.isEmpty();
    }


    public static void main(String[] args) {

        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.peek();
    }
}
