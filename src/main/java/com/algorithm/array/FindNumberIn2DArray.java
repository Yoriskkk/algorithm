package com.algorithm.array;

public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int length = matrix.length;
        if (length == 0 || matrix[0].length == 0) {
            return false;
        }
        int matrixTarget = 0;
        //遍历每一行的数据，找到targer属于哪个区间，如果等于return true，否则，在列上寻找
        for (int i = 0; i < length; i++) {
            if (target == matrix[i][0]) {
                return true;
            }
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (target == matrix[i][j] || target == matrix[i][j + 1]) {
                    return true;
                }
                if (target > matrix[i][j] && target < matrix[i][j + 1]) {
                    matrixTarget = j;
                    for (int k = i; k < length; k++) {
                        if (matrix[k][matrixTarget] == target) {
                            return true;
                        }
                    }
                    break;
                }
            }
        }

        return false;
    }

    /**
     * [[3,3,8,13,13,18],[4,5,11,13,18,20],[9,9,14,15,23,23],[13,18,22,22,25,27],[18,22,23,28,30,33],[21,25,28,30,35,35],[24,25,33,36,37,40]]
     * 21
     * @param args
     */
    public static void main(String[] args) {

        findNumberIn2DArray(case2(),-5);
    }

    public static int[][] case1(){
        int[][] out = new int[7][6];
        out[0] = new int[]{3, 3, 8, 13,13,18};
        out[1] = new int[]{4, 5, 11,13,18,20};
        out[2] = new int[]{9, 9, 14,15,23,23};
        out[3] = new int[]{13,18,22,22,25,27};
        out[4] = new int[]{18,22,23,28,30,33};
        out[5] = new int[]{21,25,28,30,35,35};
        out[6] = new int[]{24,25,33,36,37,40};
        return out;
    }
    public static int[][] case2(){
        int[][] out = new int[1][1];
        out[0] = new int[]{5};
        return out;
    }

}
