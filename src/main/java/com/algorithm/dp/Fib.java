package com.algorithm.dp;

/**
 * 动态规划，经典题目斐波那契数列
 * 使用记忆化搜索法，缓存已经计算过的斐波那契数列。
 */
public class Fib {
    public static int[] memo;

    public static int fib(int n) {
        memo = new int[101];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }

        return func(n);
    }

    public static int func(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int result = memo[n];
        if (result == -1) {
            memo[n] = func(n - 1) + func(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(48));
        long end = System.currentTimeMillis();
        System.out.println((long) end - start);
    }
}
