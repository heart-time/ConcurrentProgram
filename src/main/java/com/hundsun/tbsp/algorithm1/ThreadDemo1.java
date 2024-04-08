package com.hundsun.tbsp.algorithm1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/3/20 9:43
 */
public class ThreadDemo1 {
    static LongAdder a = new LongAdder();
    static  int count = 0;
    public void increment(){
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        integer.incrementAndGet();
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    a.increment();

                }
            }
        };


        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                a.increment();
            }
        },"t2");
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                a.increment();
            }
        },"t3");
        ReentrantLock lock  = new ReentrantLock();
        Condition condition = lock.newCondition();
        t1.start();
        t2.start();
        t3.start();
        ThreadDemo1 demo1  = new ThreadDemo1();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.execute(()->{
                for (int j = 0; j < 500; j++) {
                    demo1.increment();
                }
            });
        }
        Thread.sleep(2000);
        System.out.println(count);
        System.out.println(a);
        threadPool.shutdown();
    }
}
