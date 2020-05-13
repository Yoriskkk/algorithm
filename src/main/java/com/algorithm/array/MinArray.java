package com.algorithm.array;

public class MinArray {

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]<numbers[0]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

}
