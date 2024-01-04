package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class demo {
    private static int i=0;
    private static Logger logger= LoggerFactory.getLogger(demo.class);
    public static void main(String[] args) throws InterruptedException {
        log.info("main开始");
      Thread t1=new Thread(()->{
         log.info("t1开始");
          try {
              Thread.sleep(1);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          i=100;
          log.info("t2结束");
      },"t1");
      t1.start();
      t1.join();
      log.info("结果是:{}",i);
      log.info("结束");
    }

    @Test
    public void test1() throws InterruptedException {
        Thread t1=new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1");
        t1.start();
        log.info("开始");
        long start = System.currentTimeMillis();
//        Thread.sleep(100);
        t1.interrupt();
        long end = System.currentTimeMillis();
        log.info("是否被打断的值是:{} 结果是:{}",t1.isInterrupted(),end-start);
    }
}
