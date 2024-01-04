package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/28 9:25
 */
@Slf4j
public class ThreadPriority {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(()->{
                log.info("测试多线程的优先级,{}",Thread.currentThread().getName());
            },"t"+i);
            threads.add(t1);
        }
        int index = 1 ;
        for (Thread thread : threads) {
            if(index%3==1){
                thread.setPriority(Thread.MIN_PRIORITY);
            }else if(index%3==2){
                thread.setPriority(Thread.NORM_PRIORITY);
            }else if (index%3==0){
                thread.setPriority(Thread.MAX_PRIORITY);
            }
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
