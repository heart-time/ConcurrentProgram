package com.hundsun.tbsp.ThreadDemo;

/**
 * 懒汉式防止指令重排序
 */
public class SingletonLazy {
    //使用volatile防止指令重排序
    //比如线程1执行到了INSTANCE=new SingletonLazy()，但是指令重排序之后先调用赋值，
    //还未调用构造方法，此时线程2执行if (INSTANCE!=null){
    //            return  INSTANCE;
    //        }此时INSTANCE不为空，但是得到的是没有执行构造方法的单例，为了防止此种现象的发现，加入volatile防止指令重排序
    private static volatile SingletonLazy INSTANCE;
    private SingletonLazy(){}

    public   SingletonLazy getINSTANCE(){
        if (INSTANCE!=null){
            return  INSTANCE;
        }
        synchronized(SingletonLazy.class){
            if (INSTANCE!=null){
                return  INSTANCE;
            }
            INSTANCE=new SingletonLazy();
            return  INSTANCE;
        }

    }

}
