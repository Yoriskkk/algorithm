package com.geek._03;

import java.util.HashMap;

public class ClimbStairs2 {

    /**
     * f(n) = f(n-1) + f(n-2)
     * f(3) = f(2) + f(1)
     * f(2) = 2
     * f(1) = 1
     * 这个题其实感觉比较难理解，核心思路就是
     * 不管你要走多少皆台阶，你都要走f(n-1)和f(n-2)
     * 相当于是最后可以走一步上来，也可以最后走两步
     * 上来
     * <p>
     * 结果表示，超时时间限制，需要对重复节点做一层cache
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 有cache的版本
     *
     * @param n
     * @return
     */
    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairsWithCache(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (!map.containsKey(n)) {
            map.put(n, climbStairsWithCache(n - 1) + climbStairsWithCache(n - 2));
        } else {
            return map.get(n);
        }
        return climbStairsWithCache(n - 1) + climbStairsWithCache(n - 2);
    }

}
