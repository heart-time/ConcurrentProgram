package com.hundsun.tbsp.ThreadDemo;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/19 16:10
 */
@Slf4j
public class ThreadDemo5 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.info("start...");
//        pool.schedule(()->{
//            log.info("延时一秒执行");
//        },1, TimeUnit.SECONDS);
//        //演示一秒钟之后、每隔一秒钟定时执行，会被任务的执行时间影响
//        pool.scheduleAtFixedRate(()->{
//            log.info("每秒钟定时执行");
//            ThreadUtils.sleep(2);
//            //时间间隔被任务执行时间影响
//        },1,1,TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(()->{
            log.info("任务之间间隔一秒执行");
            ThreadUtils.sleep(2);
        },1,1,TimeUnit.SECONDS);

    }
}
