package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class WashCup {
    private static final Logger logs = LoggerFactory.getLogger(TwoPhaseTerminationMode.class);

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            try {
                log.info("开始洗水壶烧水");
                Thread.sleep(12000);
                log.info("洗水壶烧水耗时12分钟");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1");

        Thread t2=new Thread(()->{
             log.info("开始洗茶具");
            try {
                Thread.sleep(4000);
                log.info("洗茶具耗时4分钟");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t2");
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        log.info("泡茶喝耗时:{}",end-start);
    }
}
