package com.hundsun.tbsp.algorithm1;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/3/19 16:26
 */
public class DeadLockDemo {
    public static void main(String[] args) {
       Object A =new Object() ;
       Object B = new Object();
       new Thread(()->{
           synchronized (A){
               System.out.println("获取到锁A");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("等待获取锁B");
               synchronized (B){
                   System.out.println("获取到锁B");
               }
           }
       }).start();
        new Thread(()->{
            synchronized (B){
                System.out.println("获取到锁B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("等待获取锁A");
                synchronized (A){
                    System.out.println("获取到锁A");
                }
            }
        }).start();
    }
}
