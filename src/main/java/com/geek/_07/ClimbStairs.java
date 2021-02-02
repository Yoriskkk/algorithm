package com.geek._07;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    /**
     * 通过题意，很容易想到使用递归进行求解
     * 不过该方法运算超时
     * 可以使用hash表存储已经运算过的节点
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 使用hashmap做缓存
     * @param n
     * @return
     */
    Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(map.get(n) == null){
            map.put(n,climbStairs2(n-1)+climbStairs2(n-2));
        }else {
            return map.get(n);
        }
        return climbStairs2(n-1) + climbStairs2(n-2);
    }

}
