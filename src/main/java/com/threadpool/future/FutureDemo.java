package com.threadpool.future;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;


    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(executor.submit(() -> method()));
        }
        List<Object> result = new ArrayList<>();
        Long start = System.currentTimeMillis();
        Long end = 0l;
        while (list.size() > 0) {
            Iterator<Future> iterator = list.iterator();
            while (iterator.hasNext()) {
                Future next = iterator.next();
                if (next.isDone() && !next.isCancelled()) {
                    try {
                        Object o = next.get(500, TimeUnit.MILLISECONDS);
                        System.out.println("get....");
                        result.add(o);
                        iterator.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }
            }
            end = System.currentTimeMillis();
            if((end - start)>5000){
                System.out.println("超过5s...break");
                break;
            }
            System.out.println(Thread.currentThread().getName());
        }


        for (Object o : result) {
            System.out.println(JSON.toJSONString(o));
        }
        System.out.println("done...");
    }

    private static void method() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
