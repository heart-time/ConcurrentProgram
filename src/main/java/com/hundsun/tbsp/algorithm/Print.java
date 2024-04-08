package com.hundsun.tbsp.algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/3/11 16:40
 */
public class Print {
    static char nextFlag = 'a';

    public static void main(String[] args) throws InterruptedException {
        PrintClass lock = new PrintClass(5);
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        //交替打印abc循环打印五次
        Thread t1 = new Thread(()->{
            lock.print("a",c1,c2);
        },"t1");
        Thread t2 = new Thread(()->{
         lock.print("b",c2,c3);
        },"t2");
        Thread t3 = new Thread(()->{
           lock.print("c",c3,c1);
        },"t3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println("开始打印");
        try {
            lock.lock();
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
class  PrintClass extends ReentrantLock {
    private  int loopNum;

public void print(String symbol,Condition condition,Condition nextCondition){
    for (int i = 0; i < loopNum; i++) {
        lock();
        try {
            condition.await();
            System.out.print(symbol);
            nextCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            unlock();
        }

    }
}
    public PrintClass() {
    }

    public PrintClass(int loopNum) {
        this.loopNum = loopNum;
    }

    /**
     * 获取
     * @return loopNum
     */
    public int getLoopNum() {
        return loopNum;
    }

    /**
     * 设置
     * @param loopNum
     */
    public void setLoopNum(int loopNum) {
        this.loopNum = loopNum;
    }

    public String toString() {
        return "PrintClass{loopNum = " + loopNum + "}";
    }
}
