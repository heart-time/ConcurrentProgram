package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class TwoPhaseTerminationMode {
    private static final Logger logs = LoggerFactory.getLogger(TwoPhaseTerminationMode.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    logs.info("任务圆满完成成功退役");
                    break;
                }
                try {
                    //当睡眠时被打断，打断标志为false
                    Thread.sleep(1000);
                    //当在执行logs被打断，打断标志为true
                    logs.info("监控系统正常运行");
                } catch (InterruptedException e) {//捕获异常会将打断标志重置为false
                    e.printStackTrace();
                    //正常运行，调用打断方法，会将打断标志设置为true
                    Thread.currentThread().interrupt();
                }
            }
        }, "t1");
        t1.start();
        Thread.sleep(6000);
        t1.interrupt();
    }


}
