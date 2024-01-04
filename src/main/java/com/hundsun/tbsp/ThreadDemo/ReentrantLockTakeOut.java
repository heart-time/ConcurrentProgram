package com.hundsun.tbsp.ThreadDemo;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTakeOut {
    private static final Logger getLog = LoggerFactory.getLogger(ReentrantLockTakeOut.class);
    public static ReentrantLock lock=new ReentrantLock();
    static Condition smokeRoom= lock.newCondition();
    static  Condition takeOutRoom=lock.newCondition();
    static boolean hasSmoke=false;
    static  boolean hasTakeOut=false;

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            try {
                lock.lock();
                log.info("有烟没:[{}]",hasSmoke);
                while(!hasSmoke){
                    ThreadUtils.sleep(1);
                    log.info("没烟干不了活");
                    try {
                        smokeRoom.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("烟到了可以开始干活了");
            } finally {
                lock.unlock();
            }
        },"小南");

        Thread t2=new Thread(()->{
            try {
                lock.lock();
                log.info("外卖到了没有:[{}]",hasTakeOut);
                while(!hasTakeOut){
                    ThreadUtils.sleep(1);
                    log.info("没有外卖干不了活");
                    try {
                        takeOutRoom.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("外卖到了可以开始干活了");
            } finally {
                lock.unlock();
            }
        },"小女");
        t1.start();
        t2.start();
        ThreadUtils.sleep(2);
        try {
            lock.lock();
            log.info("烟到了");
            hasSmoke=true;
            smokeRoom.signal();
        } finally {
            lock.unlock();
        }

        ThreadUtils.sleep(2);
        try {
            lock.lock();
            log.info("外卖到了");
            hasTakeOut=true;
            takeOutRoom.signal();
        } finally {
            lock.unlock();
        }
    }

}
