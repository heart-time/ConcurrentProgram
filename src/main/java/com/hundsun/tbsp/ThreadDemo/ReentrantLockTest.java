package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTest {
    private static final Logger getLog = LoggerFactory.getLogger(ReentrantLockTest.class);

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //reentrantLock
        /**
         * reentrantLock可重入锁
         * 1、可以被打断
         * 2、可以设置超时时间
         * 3、可以设计为公平锁
         * 4、支持多个条件变量
         */
        Thread t1 = new Thread(() -> {
//            try {
                lock.lock();
//            } catch (InterruptedException e) {
//                log.info("被打断");
//                e.printStackTrace();
//                return;
//            }
            try {
                lock.lock();
                log.info("获取到锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        t1.start();
        t1.interrupt();
        lock.unlock();


    }
}
