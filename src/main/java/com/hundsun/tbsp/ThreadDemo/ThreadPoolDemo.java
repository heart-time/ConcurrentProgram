package com.hundsun.tbsp.ThreadDemo;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    private static  final  int CORE_POOL_SIZE=5;
    private static  final  int MAXIMUM_POOL_SIZE=10;
    private static  final  int QUEUE_CAPACITY=100;
    private static  final  long KEEP_ALIVE_TIME=1L;
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i <10 ; i++) {
            RunnableDemo runnableDemo=new RunnableDemo();
            Future submit = executor.submit(runnableDemo);
        }
        executor.shutdown();
        while(!executor.isTerminated()){};
        System.out.println("All Threads Over!!");
    }
}
