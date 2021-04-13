package com.wz.week_2.example;

public class MyArrayList {

    public int data[];
    private  int n = 10;
    private int count = 0;

    public void MyArrayList(){
        data = new int[n];
    }

    public void add(int element){
        if(count == n){
            //扩容
            int[] newData = new int[2*n];
            for (int i = 0; i < n; i++) {
                newData[i] = data[i];
            }
            n = n*2;
            data = newData;
        }
        data[count] = element;
        count++;
    }
}
