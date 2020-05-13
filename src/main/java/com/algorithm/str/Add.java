package com.algorithm.str;

public class Add {

    /**
     * 异或运算 ^ 相同为0，不同为1
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {

        if (a == 0) {
            return a;
        }
        if (b == 0) {
            return b;
        }
        int plus1 = (a ^ b);
        int plus2 = ((a & b) << 1);
        return add(plus1, plus2);

    }

}