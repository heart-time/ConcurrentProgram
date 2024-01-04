package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadLock {
    public static void main(String[] args) {
        Room2 room2=new Room2();
        new Thread(room2::sleep,"t1").start();
        new Thread(room2::eat,"t2").start();
    }
}
@Slf4j
class Room2 {
    public  static  final Logger getLog= LoggerFactory.getLogger(Room2.class);
    public  Object a=new Object();
    public Object b=new Object();

    public void sleep(){
        synchronized (a){
            log.info("睡觉");
            synchronized (b){
                log.info("继续睡觉");
            }
        }
    }
    public void eat(){
        synchronized (b){
            log.info("吃饭");
            synchronized (a){
                log.info("继续吃饭");
            }
        }
    }


}