package com.hundsun.tbsp.ThreadDemo;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;

public class RunnableDemo implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" Start Time:"+ new Date());
        process();
        System.out.println(Thread.currentThread().getName()+" End Time:"+ new Date());
        return "hello";
    }
    public void process(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test1(){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.add(2);
        Queue<List<Integer>> queues =new ArrayDeque<>();
    }
}
