package com.hundsun.tbsp.ThreadDemo;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/18 23:50
 */
@Slf4j
public class ThreadPoolDemo4 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(()->{
            log.info("begin 1");
            ThreadUtils.sleep(1);
            log.info("ending 1");
        });
        threadPool.submit(()->{
            log.info("begin 2");
            ThreadUtils.sleep(1);
            log.info("ending 2");
            return "2";

        });
        threadPool.submit(()->{
            log.info("begin 3");
            ThreadUtils.sleep(2);
            log.info("ending 3");
            return "3";
        });
        threadPool.shutdownNow();
        //调用了ShutDown方法，isShutDown返回的就是true
        log.info("others:{}",threadPool.isShutdown());
        log.info("isTerminated:{}",threadPool.isTerminated());
        threadPool.awaitTermination(4, TimeUnit.SECONDS);
        //调用shutDown方法之后要等所有的任务执行完毕isTerminated返回的才是true
        log.info("isTerminated:{}",threadPool.isTerminated());
    }
}
