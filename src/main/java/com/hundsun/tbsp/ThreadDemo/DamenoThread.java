package com.hundsun.tbsp.ThreadDemo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

public class DamenoThread {
    private static Logger log = LoggerFactory.getLogger(DamenoThread.class);

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            while (true) {
//                if (Thread.currentThread().isInterrupted()) {
//                    break;
//                }
//            }
//        }, "t1");
//        t1.setDaemon(true);//设置为守护线程，当为守护线程时，其他非守护线程执行完毕了，不管守护线程是否执行完毕都会被强制停止
//        t1.start();
//        System.out.println("开始");
//        Thread.sleep(1000);
//        System.out.println("结束");
        Hashtable<String,Integer> hj1=new Hashtable<>();

    }

    @Test
    public void test() throws InterruptedException {

    }
}
