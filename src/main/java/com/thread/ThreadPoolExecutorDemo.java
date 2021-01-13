package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    /** 核心线程数：5 **/
    private static final int CORE_POOL_SIZE = 5;
    /** 最大线程数：10 **/
    private static final int MAX_POOL_SIZE = 10;
    /** ArrayBlockingQueue队列容量：100 **/
    private static final int QUEUE_CAPACITY = 100;
    /** 等待时间：1 ，单位由构造函数指定**/
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());//饱和策略为 CallerRunsPolicy

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while(!executor.isTerminated()){

        }
        System.out.println("Finished all threads");
    }
}
