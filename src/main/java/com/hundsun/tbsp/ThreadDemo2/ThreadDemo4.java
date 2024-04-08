package com.hundsun.tbsp.ThreadDemo2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2024/3/21 15:20
 */
public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        String temp[] = new String[10];
        Random random = new Random();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int index = i;
            threadPool.execute(()->{
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(random.nextInt(200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    temp[index] = String.valueOf(j+1);
                    System.out.print("\r"+Arrays.toString(temp));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("游戏加载结束");
        threadPool.shutdown();
    }
}
