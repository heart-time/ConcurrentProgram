package com.hundsun.tbsp.ThreadDemo;

/**
 * 通过静态内部类获取单利模式
 */
public class SingletonInnerClass {
    //由于静态变量在类加载阶段都是懒汉式的，会在真正调用的时候才回加载值，所以通过静态内部类获取的单例模式也是懒汉式的
    private static class InnerClass{
        private final static  SingletonInnerClass INSTANCE=new SingletonInnerClass();
    }
    public SingletonInnerClass getINSTANCE(){
        return  InnerClass.INSTANCE;
    }
}
