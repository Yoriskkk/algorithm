package com.threadpool.countdown;

import java.util.concurrent.CountDownLatch;

public class Driver {

    public static void main(String[] args) throws Exception{
        int N = 9;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(startSignal,doneSignal)).start();
        }
        System.out.println("....");
        startSignal.countDown();
        doneSignal.await();
    }

}
