package com.algorithm.recursion;

public class ClimbStairs {

    public static int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            b += a;
            a = b - a;
        }
        return a;
    }

    public static void main(String[] args) {
        int i = 3;
        climbStairs(i);
    }
}
