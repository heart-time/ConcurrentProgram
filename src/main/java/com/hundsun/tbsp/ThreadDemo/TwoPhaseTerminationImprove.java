package com.hundsun.tbsp.ThreadDemo;

public class TwoPhaseTerminationImprove {
    public static void main(String[] args) throws InterruptedException {
        TwoTermination two=new TwoTermination();
        new Thread(two::start).start();
        Thread.sleep(4000);
        new Thread(two::stop).start();
    }
}
class  TwoTermination{
    volatile static  boolean stop;
    static Thread t1;

    public  void start(){
      t1= new Thread(()->{
            while(true){
                if (stop){
                    System.out.print("料理后事");
                    break;
                }
                try {
                    System.out.println("监控记录");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        },"t1");
       t1.start();
    }
    public void stop(){
        stop=true;
        t1.interrupt();
    }

}
