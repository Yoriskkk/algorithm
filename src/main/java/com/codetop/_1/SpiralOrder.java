package com.codetop._1;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {

    /**
     * 思路：
     * 通过i，j控制方向
     * 无脑往右j++，如果触达右边界,就往下i++,触达边界，就往左j--,触达边界就往上i--
     * 如何控制方向？
     * 左上角往右
     *      判断条件,触达左边界&&上边界 或者 左边的数为101&&上边的数为101 或者 触达左边界&&上边的数的为101 或者左边的数
     * 右上角往下
     * 右下角往左
     * 左下角往上
     * 上述判断条件过于繁琐
     *
     * 首先往右，碰到边界就往下，碰到边界就往左，碰到边界就往上，然后循环
     *  0->右
     *  1->下
     *  2->左
     *  3->上
     *
     * 终止条件
     * 上下左右都是边界或者数值为101
     *
     * 遍历过了的值，将其修改为101，因为题目表示每一个网格的值的上限是100
     *
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        dfs(matrix,0,0,0,0,matrix.length-1,0,matrix[0].length-1);
        return list;
    }

    private void dfs(int[][] matrix, int i, int j,int direction,int top,int bottom,int left,int right) {
        //终止条件
        //这里的终止条件，需要反复思考一下
        // 当top == bottom的时候，其实是属于到最终的节点，所以其实是可以add到list的
        if(top > bottom || left > right){
            return ;
        }
        list.add(matrix[i][j]);
        if(direction == 0){
            if(j==right && i == top){//碰到右边界
                top ++;
                dfs(matrix,++i,j,1,top,bottom,left,right);
            }else {
                dfs(matrix,i,++j,direction,top,bottom,left,right);
            }
        }
        if(direction == 1){
            if(i == bottom && j == right){//碰到下边界
                right --;
                dfs(matrix,i,--j,2,top,bottom,left,right);
            }else{
                dfs(matrix,++i,j,direction,top,bottom,left,right);
            }
        }
        if(direction == 2){
            if(i == bottom && j == left){//碰到左边界
                bottom --;
                dfs(matrix,--i,j,3,top,bottom,left,right);
            }else {
                dfs(matrix,i,--j,direction,top,bottom,left,right);
            }
        }
        if(direction == 3){
            if(i == top && j == left){//碰到上边界
                left ++;
                dfs(matrix,i,++j,0,top,bottom,left,right);
            }else {
                dfs(matrix,--i,j,direction,top,bottom,left,right);
            }
        }
    }

    /**
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * [[1,2,3],[4,5,6],[7,8,9]]
     */
    @Test
    public void test(){
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(arr);
    }

}
