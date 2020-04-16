package com.threadpool;

import java.util.concurrent.Executor;

public class MyThread {

    /**
     * 线程池
     * new Thread
     *
     *
     *
     */
    public static void main(String[] args) {
        Executor executor= new Executor() {
            public void execute(Runnable command) {

            }
        } ;
    }
}
