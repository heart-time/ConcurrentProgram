package com.hundsun.tbsp.ThreadDemo;

public class UsedVolatile {
    //volatile保证静态变量、成员变量的可见性
    //可以避免从线程的工作内存中读取旧值，而是每次都从直接内存中读取最新的值
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                System.out.println(flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        Thread.sleep(1000);
        System.out.println("一秒后");
        flag = false;
    }
}
