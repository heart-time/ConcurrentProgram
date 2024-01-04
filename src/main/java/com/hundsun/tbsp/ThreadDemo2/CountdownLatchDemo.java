package com.hundsun.tbsp.ThreadDemo2;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/12/4 20:01
 */
@Slf4j
public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new Thread(()->{
            log.info("begin...");
            ThreadUtils.sleep(1);
            log.info("ending....");
            latch.countDown();
        },"t1").start();
        new Thread(()->{
            log.info("begin...");
            ThreadUtils.sleep(2);
            log.info("ending....");
            latch.countDown();
        },"t1").start();
        new Thread(()->{
            log.info("begin...");
            ThreadUtils.sleep(3);
            log.info("ending....");
            latch.countDown();
        },"t1").start();
        latch.await();
        log.info("all ending...");
    }
}
