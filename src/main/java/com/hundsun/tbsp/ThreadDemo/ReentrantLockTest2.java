package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTest2 {
    private static final Logger getLog = LoggerFactory.getLogger(ReentrantLockTest2.class);
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        Thread t1=new Thread(()->{
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    log.info("没有获取到锁");
                    return;
                }
            } catch (InterruptedException e) {
                log.info("被打断了，没有获取锁");
                e.printStackTrace();
                return;
            }
            log.info("获取到锁");
        },"t1");

        log.info("主线程获取到锁");
        lock.lock();
        t1.start();
        Thread.sleep(1000);
        lock.unlock();

    }

}
