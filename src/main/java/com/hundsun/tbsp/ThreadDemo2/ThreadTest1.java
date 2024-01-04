package com.hundsun.tbsp.ThreadDemo2;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/11/28 19:10
 */
public class ThreadTest1 {
    public static final ThreadLocal<Long> TIME_THREADLOCAl = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public void start(){
        TIME_THREADLOCAl.set(System.currentTimeMillis());
    }
    public long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAl.get();
    }

    public static void main(String[] args) {
        ThreadTest1 t1 = new ThreadTest1();
        t1.start();
        ThreadUtil.sleep(2000);
        System.out.println("两个方法之间间隔"+t1.end());
    }

}
