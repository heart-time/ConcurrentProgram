package com.hundsun.tbsp.ThreadDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger integer=new AtomicInteger(10);
        System.out.println(integer.incrementAndGet());
        System.out.println(integer.getAndIncrement());
        System.out.println(integer.getAndAdd(-1*5));
        ArrayList list=new ArrayList();
        Queue<Integer> queue=new LinkedList<>();
        Stack stack =new Stack();
        System.out.println(integer.updateAndGet(value->value*3+40-30));

    }
}
