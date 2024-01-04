package com.hundsun.tbsp.ThreadDemo2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/12/4 20:57
 */
@Slf4j
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2,()->{
            log.info("t1 t2 ending...");
        });
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(() -> {
                log.info("t1 start...");
                try {
                    Thread.sleep(1000);
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
            threadPool.execute(() -> {
                log.info("t2 start...");
                try {
                    Thread.sleep(2000);
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPool.shutdown();
    }
}
