package com.action;

public class ThreadLocalDemo {


    // ThreadLocal 与当前线程绑定  可以看作是一个容器 保证了存放里面的数据是线程安全的
    public static void main(String[] args){

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(100);

        //两个线程
        new Thread(()->{
            threadLocal.set(23);
            System.out.println("thread get: "+threadLocal.get());//永远是23
        }).start();

        System.out.println("main thread get: "+threadLocal.get()); //永远是 100 在主线程
    }
}
