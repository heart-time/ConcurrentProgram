package com.hundsun.tbsp.ThreadDemo2;

import com.hundsun.tbsp.utils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2024/3/21 15:13
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; i++) {
            threadPool.submit(()->{
                try {
                    semaphore.acquire();
                    ThreadUtils.sleep(1);
                    System.out.println("输出日志");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                 semaphore.release();
                }
            });
        }
        ThreadUtils.sleep(5);
        System.out.println("执行结束");
        threadPool.shutdown();
    }
}
