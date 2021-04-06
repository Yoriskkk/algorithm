package com.threadpool.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {

    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "hello completableFuture";
        });

        /**
         * thenAcceptBoth，组合使用CompletableFuture，对两个future的值进行操作
         */
        future.thenAcceptBoth(CompletableFuture.completedFuture("compose"),(x,y) -> {
            System.out.println(x);
            System.out.println(y);
            System.out.println(x+y);

        });

        /**
         * thenAccept，提交一个没有返回值的任务
         */
        CompletableFuture<Void> without_return_value = future.thenAccept((e) -> {
            System.out.println("without return value");
        });
        try {
            System.out.println(without_return_value.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * thenApply 提交一个有返回值的任务，可以获取到future的值（作为参数）
         */
        CompletableFuture<String> future1 = future.thenApply((element) -> {
            return element + " addPart";
        }).thenApply((element) -> {
            return element + "addTwoPart";
        });
        try {
            System.out.println(future.get());
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
