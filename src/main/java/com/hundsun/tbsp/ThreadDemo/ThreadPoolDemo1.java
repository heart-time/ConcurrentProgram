package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/18 22:53
 */
@Slf4j
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger num = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"mypool_t" + num.getAndIncrement());
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                log.info("1");
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                log.info("2");
            }
        });
        threadPool.execute(()->{
            log.info("3");
        });
    }
}
