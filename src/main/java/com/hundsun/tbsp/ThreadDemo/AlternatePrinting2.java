package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class AlternatePrinting2 {
    private static final Logger getLog = LoggerFactory.getLogger(AlternatePrinting2.class);
    static   Notify notify=new Notify(5);
    ;
    static Condition printOne=notify.newCondition();
    static Condition printTwo=notify.newCondition();
    static Condition printThree=notify.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            notify.print("a",printOne,printTwo);
        },"t1").start();

        new Thread(()->{
            notify.print("b",printTwo,printThree);
        },"t2").start();

        new Thread(()->{
            notify.print("c",printThree,printOne);
        },"t3").start();

        Thread.sleep(1000);
        log.info("开始交替打印");
        try {
            notify.lock();
            printOne.signal();;
        } finally {
            notify.unlock();
        }
    }

}
class Notify extends ReentrantLock{
    private  int loopNum;

    public Notify() {
    }

    public Notify(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String content,Condition now,Condition next){
        for (int i = 0; i < loopNum; i++) {
            try {
                lock();
                try {
                    now.await();
                    System.out.print(content);
                    next.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
               unlock();
            }
        }
    }



}