package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.test")
public class Main {
    public   static Logger logger= LoggerFactory.getLogger(Main.class);
    public   static  int stocks=100;
    public static void main(String[] args) {
        Runnable runnable= () -> stocks--;
          Thread t1=new Thread(()->{
              while(stocks>0){
                  stocks--;
                 logger.error(Thread.currentThread()+" "+stocks);
              }

          },"t1");
        Thread t2=new Thread(()->{
            while(stocks>0){
                stocks--;
               logger.error(Thread.currentThread()+" "+stocks);
            }
        },"t2");
        Thread t3=new Thread(()->{
            while(stocks>0){
                stocks--;
               logger.error(Thread.currentThread()+" "+stocks);
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();

    }


    @Test
    public void test1() throws ExecutionException, InterruptedException {
//        FutureTask<Integer> f1=new FutureTask<>(()->{
//            log.info("running");
//            Thread.sleep(2000);
//            return  100;
//        });
//
//        FutureTask<HashMap<String,Integer>> f3=new FutureTask(new Callable() {
//            @Override
//            public String call() throws Exception {
//                return "这是一个什么东西";
//            }
//        });
//        Thread t1=new Thread(f1,"他00");
//        t1.start();
//        Thread t2=new Thread(f3,"Niubi");
//        HashMap<String, Integer> stringIntegerHashMap = f3.get();
//        t2.start();
//        log.info("{}",stringIntegerHashMap.get("这是一个东西"));
//        log.info("{}",f3.get());
//        log.info("打印的值是:{}",f1.get());
        System.out.println(stocks);
        log.info("{}这是什么情况",stocks);
    }

    @Test
    public void test100() throws ExecutionException, InterruptedException {
        Thread t1=new Thread(()->{
            while (stocks>0){
                stocks--;
                log.info("{}running:{}",Thread.currentThread(),stocks);
            }
        },"t1");
        FutureTask<Integer>  f1=new FutureTask<>(()->{
            while (stocks>0){
                stocks--;
                log.info("{}running:{}",Thread.currentThread(),stocks);
            }
        },100);
        Thread t2=new Thread(f1,"t2");
        Integer integer = f1.get();
        t1.setPriority(10);
        t2.setPriority(2);
        t1.start();
        t2.start();

    }
    @Test
    public  void  test101() throws  InterruptedException{
        Thread t1=new Thread(()->{
            log.info("进入t1线程");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.info("线程被打断");
                throw new RuntimeException(e);
            }
        },"t1");
        t1.start();
        t1.interrupt();
        log.info("main线程");
    }
    @Test
    public void tets102(){
        Thread t1=new Thread(()->{
            int count=0;
            for (;;){
                Thread.yield();
                System.out.println("------>"+count++);
            }
        },"t1");
        Thread t2=new Thread(()->{
            int count=0;
            for (;;){
                System.out.println("         ------>"+count++);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}