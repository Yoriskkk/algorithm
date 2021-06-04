package com.demo;

import java.util.HashMap;
import java.util.Map;

public class Test {

    static final Counter staticFinalCounter = new Counter();
    final Counter finalCounter = new Counter();

    public String toString(){
        return "finalCounter=" + finalCounter + ",\n" + "staticFinalCounter=" + staticFinalCounter;
    }

    public static void main(String[] args) {
        /*Map<Integer,User> map1 = new HashMap<>();
        User


        Map<Integer,User> map2 = new HashMap<>();*/

    }

}
