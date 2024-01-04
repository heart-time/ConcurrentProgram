package com.hundsun.tbsp.ThreadDemo2;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/12/4 19:24
 */
@Slf4j
public class SemaPhoneDemo {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    s.acquire();
                    log.info("当前线程:{}",Thread.currentThread().getName());
                    ThreadUtils.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    s.release();
                }
            },"t"+i).start();
        }
    }
}
