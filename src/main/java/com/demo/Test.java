package com.demo;

public class Test {

    static final Counter staticFinalCounter = new Counter();
    final Counter finalCounter = new Counter();

    public String toString(){
        return "finalCounter=" + finalCounter + ",\n" + "staticFinalCounter=" + staticFinalCounter;
    }

}
