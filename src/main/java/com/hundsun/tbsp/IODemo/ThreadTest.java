package com.hundsun.tbsp.IODemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.IODemo
 * @Description
 * @date 2023/11/6 10:53
 */
@Slf4j
public class ThreadTest {
    private static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    public static void main(String[] args) throws InterruptedException {
        alternatePrint alternatePrint = new alternatePrint(5);
        Condition a = alternatePrint.newCondition();
        Condition b = alternatePrint.newCondition();
        Condition c = alternatePrint.newCondition();
        Thread t1 = new Thread(() -> {
            alternatePrint.print("a", a, b);
        }, "t1");
        Thread t2 = new Thread(() -> {
            alternatePrint.print("b", b, c);
        }, "t2");
        Thread t3 = new Thread(() -> {
            alternatePrint.print("c", c, a);
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1200);
        log.info("开始执行交替打印");
        try {
            alternatePrint.lock();
            a.signal();
        } finally {
            alternatePrint.unlock();
        }
    }
}

class alternatePrint extends ReentrantLock {
    private int loopNumber;

    public alternatePrint(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public int getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String content, Condition now, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            try {
                lock();
                now.await();
                System.out.print(content);
                Thread.sleep(500);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}
