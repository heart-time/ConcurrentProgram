package com.hundsun.tbsp.ThreadDemo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/28 10:09
 */
@Slf4j
public class ThreadInterrupt {
    public static void main(String[] args) {
        AlterPrint alterPrint = new AlterPrint(5, 1);

        new Thread(() -> {
            alterPrint.print(1, 2, "a");
        }, "t1").start();
        new Thread(() -> {
            alterPrint.print(2, 3, "b");
        }, "t2").start();
        new Thread(() -> {
            alterPrint.print(3, 1, "c");
        }, "t3").start();

    }
}

@Slf4j
class Print extends ReentrantLock {
    private int loopNumber;

    @SneakyThrows
    public void print(String s, Condition now, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                now.await();
                log.info(s);
                next.signalAll();
            } finally {
                unlock();
            }
        }
    }

    public Print(int loopNumber) {
        this.loopNumber = loopNumber;
    }

}

@Slf4j
class AlterPrint {
    private int loopNumber;
    private int currentNumber;

    public AlterPrint(int loopNumber, int currentNumber) {
        this.currentNumber = currentNumber;
        this.loopNumber = loopNumber;
    }

    public void print(int now, int next, String content) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (now != currentNumber) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                }
                log.info(content);
                currentNumber = next;
                notifyAll();
            }
        }
    }

}


