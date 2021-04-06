package com.threadpool.future;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class App {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static ExecutorService executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                sleep(1001);
                return "test";
            }
        });
        String s = null;
        try {
            s = future.get(1000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }

}
