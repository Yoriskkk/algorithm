package com.codetop.dp;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

@Slf4j
public class MaxSubArray {

    /**
     * 状态定义：
     * dp[i] 表示以i结尾的最大连续子数组的和,
     * 状态转移方程
     * dp[i] = dp[i-1] + nums[i]
     * return Math.max(dp[0]~dp[i])
     *
     * 腾讯cdg，修改返回值为子数组
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];//不能赋值为Integer.MIN_VALUE,nums.length=1时会有问题
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            log.info("dp[{}]={}",i,dp[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public Object[] maxSubArray2(int[] nums) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ArrayList list = new ArrayList();
        list.add(nums[0]);
        map.put(dp[0], list);
        int max = nums[0];//不能赋值为Integer.MIN_VALUE,nums.length=1时会有问题
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1] + nums[i] > nums[i]){
                dp[i] = dp[i-1] + nums[i];
                ArrayList<Integer> temp = map.get(dp[i - 1]);
                ArrayList<Integer> cur = new ArrayList<>(temp.size());
                for (Integer elem: temp) {
                    cur.add(elem);
                }
                cur.add(nums[i]);
                map.put(dp[i],cur);
                log.info("dp[{}]={}",i,dp[i]);
            }else {
                dp[i] = nums[i];
                ArrayList list2 = new ArrayList();
                list2.add(nums[i]);
                map.put(dp[i],list2);
            }
            max = Math.max(dp[i],max);
        }
        return map.get(max).toArray();
    }

    @Test
    public void test(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(6,maxSubArray2(nums));
    }

}
