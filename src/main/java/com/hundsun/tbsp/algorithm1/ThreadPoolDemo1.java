package com.hundsun.tbsp.algorithm1;

import java.util.concurrent.*;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/3/20 15:54
 */
public class ThreadPoolDemo1 {
    public static final Integer CORE_SIZE = 5;
    public static final Integer MAX_SIZE = 10;
    public static final Integer WAIT_TIME = 5;
    static int fds = 100;
    public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    public static void main(String[] args) {
        Callable callable  = new Callable() {
            @Override
            public Object call() throws Exception {
                fds++;
                return fds;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(futureTask,"t1");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_SIZE,MAX_SIZE,WAIT_TIME,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        pool.submit((Callable<Integer>) () -> null);

    }
}
