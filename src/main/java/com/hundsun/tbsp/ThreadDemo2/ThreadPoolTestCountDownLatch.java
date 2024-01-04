package com.hundsun.tbsp.ThreadDemo2;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/12/4 20:20
 */
@Slf4j
public class ThreadPoolTestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(()->{
            log.info("begin...");
            ThreadUtils.sleep(1);
            log.info("ending....");
            latch.countDown();
        });
        threadPool.execute(()->{
            log.info("begin...");
            ThreadUtils.sleep(2);
            log.info("ending....");
            latch.countDown();
        });
        threadPool.execute(()->{
            log.info("begin...");
            ThreadUtils.sleep(3);
            log.info("ending....");
            latch.countDown();
        });
        threadPool.execute(()->{
            log.info("begin...");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("all ending...");
        });

    }

}

