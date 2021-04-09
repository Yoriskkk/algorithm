package com.wz.week_1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if(row.contains(i)){
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if(column.contains(j)){
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                    continue;
                }
            }
        }


    }

    @Test
    public void test(){
        int[][] arr = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(arr);
    }


}
