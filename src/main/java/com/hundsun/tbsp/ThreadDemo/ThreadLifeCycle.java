package com.hundsun.tbsp.ThreadDemo;

import com.hundsun.tbsp.utils.ThreadUtils;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/28 9:40
 */
public class ThreadLifeCycle {
    public static void main(String[] args) {
        new Thread(new TimedWaiting(),"TimedWating").start();
        new Thread(new Waiting(),"Waiting").start();
        new Thread(new Blocked(),"Blocked-1").start();
        new Thread(new Blocked(),"Blocked-2").start();
    }


}

/**
 * Java中的线程状态主要有六种
 * NEW创建态
 * TIME_WAITING有限等待
 * WAITING等待态
 * BLOCKED阻塞态
 * RUNNABLE运行态
 * TERMINATE终止态
 * 守护线程daemon需要在线程启动之前设置不能在线程启动之后设置
 * 守护线程
 */
class TimedWaiting implements Runnable{
    @Override
    public void run() {
        while(true){
            synchronized (TimedWaiting.class){
                try {
                    TimedWaiting.class.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class Waiting implements  Runnable{

    @Override
    public void run() {
       while(true){
           synchronized(Waiting.class){
               try {
                   Waiting.class.wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }
    }
}

class  Blocked implements  Runnable{

    @Override
    public void run() {
        while(true){
            synchronized (Blocked.class){
                ThreadUtils.sleep(100);
            }
        }
    }
}