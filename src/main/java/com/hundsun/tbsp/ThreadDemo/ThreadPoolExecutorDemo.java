package com.hundsun.tbsp.ThreadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static  final  int CORE_POOL_SIZE=5;
    private  static  final  int MAXIMUM_POOL_SIZE=10;
    private static  final Long KEEP_ALIVE_TIME=1L;
    private static  final  int QUEUE_CAPACITY=100;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(
                        CORE_POOL_SIZE,
                        MAXIMUM_POOL_SIZE,
                        KEEP_ALIVE_TIME,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                        new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i <10 ; i++) {
            Runnable runnable=new RunnableClass(""+i);
            threadPoolExecutor.execute(runnable);
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        while(!threadPoolExecutor.isTerminated()){}
        System.out.println("All Threads Terminate");
    }
}
