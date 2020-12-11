package com.geek._03;

import java.util.HashMap;

/**
 * 思路1：
 * 1.首先总结规律，F(n) = F(n-1) + F(n-2)，这是因为，你要上第n阶台阶
 * 你的最后一步要么是垮一步，要么是垮两步,这里使用递归
 * 首先，找到终止条件
 * F(1) = 1,F(2) = 2,该方法由于节点重复结算过多，提交超时，需要思考优化策略
 * 2.对于已经计算过后的节点，我们可以使用map进行存储，如果map.get()!=null,直接用，否则put到map中
 */
public class ClimbStairs {

    public static HashMap map = new HashMap();
    public static int climbStairs(int n) {

        //终止条件
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if(map.get(n)!=null){
            return (int) map.get(n);
        }else {
            map.put(n,climbStairs(n - 1) + climbStairs(n - 2));
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {

        int i = climbStairs(4);
        System.out.println(i);

    }

}
