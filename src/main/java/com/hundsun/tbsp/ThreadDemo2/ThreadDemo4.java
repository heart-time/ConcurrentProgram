package com.hundsun.tbsp.ThreadDemo2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2024/3/21 15:20
 */
public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
       Thread t1 =new Thread("fdsafa");
        t1.start();
        Callable c1 =new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable");
                throw new RuntimeException("故意抛出一个异常");
            }
        };
        FutureTask<Integer> f1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable");
                return 100;
            }
        });
         Runnable r1 = new Runnable() {
             @Override
             public void run() {
                 System.out.println("fdsafdsa");
             }
         };
        Thread t2 = new Thread(()->{

        });

    }
}
