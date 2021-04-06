package com.threadpool.countdown;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class Worker implements Runnable{

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal,CountDownLatch doneSignal){
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run(){

        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        log.info("current thread:{},work ...",Thread.currentThread().getName());
    }


}
