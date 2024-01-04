package com.hundsun.tbsp.ThreadDemo;

/**
 * 单例模式有懒汉式、饿汉式、静态内部类的模式
 */
public class Singleton {
    private static  final  Singleton INSTANCE=new Singleton();
    private Singleton(){}
    public Singleton getInstance(){
        return INSTANCE;
    }
}
