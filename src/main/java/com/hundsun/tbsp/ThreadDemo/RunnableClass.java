package com.hundsun.tbsp.ThreadDemo;

import java.util.Date;

public class RunnableClass implements  Runnable{
    private String command;
    public RunnableClass(String command){
        this.command=command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start.Time="+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.Time="+new Date());

    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "  "+this.command;
    }
}
