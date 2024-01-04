package com.hundsun.tbsp.ThreadDemo;


import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Test1 {
    public static final Logger log= LoggerFactory.getLogger(Test1.class);
    static final Object lock=new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){
                log.info("开始运行");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("结束运行");
            }
        },"t1").start();
        new Thread(()->{
            synchronized (lock){
                log.info("开始运行");
                try {
                    lock.wait(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("结束运行");
            }
        },"t2").start();
        ThreadUtils.sleep(2);
        synchronized(lock){
            lock.notify();
        }

    }
}
