package com.codetop._1;

public class EightQueen {
    int[] result = new int[8];//index表示行，值表示queen存储在哪一列

    public void cal8queens(int row){
        if(row == 8){ //8个旗子都放置好了，打印结果
            printQueens(result);
            return;//8行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for (int column = 0; column < 8;column ++){//每一行有8个放法
            /*if(isOk(row,column)){ //有些方法不满足要求
                result[row] = column;//第row行的棋子放到了column列
                cal8queens(row+1);//考察下一行
            }*/
        }
    }

    private void printQueens(int[] result) {


    }

}
