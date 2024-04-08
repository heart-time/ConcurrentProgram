package com.hundsun.tbsp.algorithm1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/3/20 11:12
 */
public class Singleton {
    public  static volatile Singleton singleton ;
    public Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    static int count ;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.execute(()->{
                for (int j = 0; j < 500; j++) {
                    count++;
                }
            });
        }
        Thread.sleep(2000);
        System.out.println("count的值是:"+count);
        threadPool.shutdown();
    }
}
