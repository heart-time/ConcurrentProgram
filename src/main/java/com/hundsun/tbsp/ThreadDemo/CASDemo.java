package com.hundsun.tbsp.ThreadDemo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/27 21:13
 */
public class CASDemo {
    private static AtomicInteger integer = new AtomicInteger(0);
    private  static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                   safe();
                   unsafe();
                }
            },"t"+i);
         list.add(t1);
        }
        for (Thread thread : list) {
            thread.start();
        }
        for(Thread thread : list){
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(integer.get());
        System.out.println(endTime-startTime);
    }
    public static void safe(){
       while (true){
           int target = integer.get();
           boolean b = integer.compareAndSet(target, target + 1);
           if(b){
               break;
           }
       }
    }
    public static void unsafe(){
        count++;
    }
}
