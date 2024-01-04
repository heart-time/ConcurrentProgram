package com.hundsun.tbsp.ThreadDemo2;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/12/7 15:35
 */
@Slf4j
class Test1 {
    private static int age = 18;

    public static void main(String[] args) throws InterruptedException {

       Thread t1 = new Thread(()->{
           age++;
           log.info("t1线程执行++操作");
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       },"t1");
       t1.start();
       Thread.sleep(10);
       new Thread(){
         @SneakyThrows
         @Override
         public void run(){
             Thread.sleep(100);
             log.info("读取age的值是不是最新值:{}",age);
             t1.join();
             log.info("读取age的值是不是最新值:{}",age);
         }
       }.start();
    }
}
