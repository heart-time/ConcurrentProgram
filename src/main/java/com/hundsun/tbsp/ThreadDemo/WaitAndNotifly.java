package com.hundsun.tbsp.ThreadDemo;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class WaitAndNotifly {
    public static final Logger log2= LoggerFactory.getLogger(WaitAndNotifly.class);

    public static final Object lock=new Object();
    public static boolean isSmoke=false;
    public  static boolean takeout=false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            log.info("有烟没:{}",isSmoke);
                synchronized (lock){
                    while (!isSmoke){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            log.info("有烟没:{}",isSmoke);
            if (isSmoke){
                log.info("开始干活");
            }else {
                log.info("没烟无法干活");
            }
        },"小女").start();
        new Thread(()->{
            log.info("有外卖没:{}",isSmoke);
                synchronized (lock){
                    while(!takeout){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            log.info("有外卖没:{}",takeout);
            if (takeout){
                log.info("开始干活");
            }else {
                log.info("没有外卖无法干活");
            }
        },"小南").start();

        ThreadUtils.sleep(1);
        synchronized (lock){
            isSmoke=true;
            log.info("烟到了");
            lock.notifyAll();
        }
        synchronized (lock){
            Thread.sleep(4000);
            takeout=true;
        }

    }
}
