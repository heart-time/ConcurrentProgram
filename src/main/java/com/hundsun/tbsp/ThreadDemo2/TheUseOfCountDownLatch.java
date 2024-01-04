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
 * @date 2023/12/4 20:32
 */
public class TheUseOfCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        String[] temp = new String[10];
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CountDownLatch latch  = new CountDownLatch(10);
        Random random = new Random();
        for (int j = 0; j < 10; j++) {
            int k = j ;
            threadPool.submit(()->{
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(random.nextInt(300));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    temp[k] = (i+1)+"%";
                    System.out.print("\r"+ Arrays.toString(temp));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n"+"游戏开始");
        threadPool.shutdown();
    }
}
