package com.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    /**
     * 该方法，代码清晰，不过对于重复结果没有缓存，所以超过leetcode的时间限制
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

    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int climbStairs2(int n) {
        if(n == 1){
            map.put(1,1);
            return 1;
        }
        if(n == 2){
            map.put(2,2);
            return 2;
        }
        if(map.get(n)!=null){
            return map.get(n);
        }else {
            Integer result = climbStairs2(n-1) + climbStairs2(n-2);
            map.put(n,result);
            return result;
        }
    }
}
