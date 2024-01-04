package com.hundsun.tbsp.ThreadDemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlternatePrinting {

    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify=new WaitNotify(1,5);
        new Thread(()->{
            waitNotify.print("a",1,2);
        },"t1").start();
        new Thread(()->{
            waitNotify.print("b",2,3);
        },"t2").start();
        new Thread(()->{
            waitNotify.print("c",3,1);
        },"t3").start();

    }
}
class WaitNotify{
    private  int currentFlag;
    private  int loopNumber;
    public void print(String printNum,int nowflag,int nextFlag) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while(!(currentFlag==nowflag)){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(printNum);
                currentFlag=nextFlag;
                this.notifyAll();
            }
        }
    }
    public  WaitNotify(int currentFlag,int loopNumber){
        this.currentFlag=currentFlag;
        this.loopNumber=loopNumber;
    }
}
