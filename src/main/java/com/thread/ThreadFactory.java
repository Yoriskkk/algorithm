package com.thread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.concurrent.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadFactory {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            /*executorService.execute(new Task<>() {
                System.out.println();
            });*/
        }

    }

}
