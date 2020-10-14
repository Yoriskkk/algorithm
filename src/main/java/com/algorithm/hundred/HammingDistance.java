package com.algorithm.hundred;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int result = x^y;
        String s = Integer.toBinaryString(result);
        System.out.println(s);
        int size = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                size++;
            }
        }
        return size;
    }

    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x,y));
    }

}
