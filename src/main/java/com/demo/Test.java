package com.demo;

public class Test {

    static final Counter staticFinalCounter = new Counter();
    final Counter finalCounter = new Counter();

    public String toString(){
        return "finalCounter=" + finalCounter + ",\n" + "staticFinalCounter=" + staticFinalCounter;
    }

    public static void main(String[] args) {
        String str ="0,1";
        String[] split = str.split(",");
    }

}
