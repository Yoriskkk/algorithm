package com.demo;

public class Counter {
    private static int counter;
    private int id = counter++;

    public String toString() {
        return "Counter: " + id;
    }
}
