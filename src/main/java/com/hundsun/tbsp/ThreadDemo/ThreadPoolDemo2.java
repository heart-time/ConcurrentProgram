package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/18 23:16
 */
@Slf4j
public class ThreadPoolDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<String> future = threadPool.submit(() -> {
            log.info("running");
            try {
                Thread.sleep(1000);
                return "Ok";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "fail";
        });
        log.info("result:{}",future.get());
    }
}
