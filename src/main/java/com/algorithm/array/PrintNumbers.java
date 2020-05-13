package com.algorithm.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题17. 打印从1到最大的n位数
 */
//@Slf4j
public class PrintNumbers {

    public static int[] printNumbers(int n) {

        List arr = new ArrayList();
        int length = (int)Math.pow(10,n);
        int[] result = new int[length-1];
        for (int i = 1; i < length; i++) {
            result[i-1] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = printNumbers(1);
        for (int a:  ints
             ) {
            System.out.println(a);
        }
        System.out.println(ints.toString());
//        log.info("result:{}",ints.toString());
    }

}
