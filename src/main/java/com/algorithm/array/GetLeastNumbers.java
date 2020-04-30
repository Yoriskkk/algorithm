package com.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {

        List<Integer> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
