package com.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 等差数列求和公式
 * Sn = 首项*项数+项数*(项数-1)*公差/2
 */
public class FindContinuousSequence {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList();
        //由于题目中明确说明项数至少含有两个,所以n从2开始++，循环终止条件为首项<0
        double a1 = 0.0;
        int n = 2;
        int max = 0;
        while (true) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            int i1 = (target - n * (n - 1) / 2) % n;
            if(i1==0){
                a1 = (target - n * (n - 1) / 2) / n;
            }
            if (a1 <= 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                innerList.add((int)a1 + i);
            }
            max = Math.max(max, innerList.size());
            int[] arr = new int[innerList.size()];
            for (int i = 0; i < innerList.size(); i++) {
                arr[i] = innerList.get(i);
            }
            list.add(0, arr);

            n++;
        }
        /*int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            int arr2[] = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }*/
        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {
        findContinuousSequence(15);
    }

}
