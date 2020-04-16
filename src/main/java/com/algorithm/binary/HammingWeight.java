package com.algorithm.binary;

public class HammingWeight {

    /**
     * 与运算，两个同时为1才为1，否则为0
     * 或运算，一个为1则为1
     * 异或运算，两个不同，值为1，否知为0
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {

        String s = Integer.toBinaryString(n);
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                size++;
            }
        }
        /*char[] chars = s.toCharArray();
        int size = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '1'){
                size++;
            }

        }*/
        return size;
    }

    /**
     * 使用与运算n&（n-1）即可得到1的位数
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {

        int size = 0;
        while (n != 0) {
            n &= n - 1;
            size++;
        }
        return size;
    }

}
