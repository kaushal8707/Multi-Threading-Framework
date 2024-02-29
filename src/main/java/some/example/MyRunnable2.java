package com.home.java.demo.thread;

import java.util.concurrent.locks.Lock;

public class MyRunnable2 implements Runnable
{
    Lock lock;
    public MyRunnable2(Lock lock) {
        this.lock=lock;
    }
    public void run(){

        System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire lock");

        lock.lock();
        System.out.println(Thread.currentThread().getName()
                +" has acquired lock.");

        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()
                    +" is sleeping.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
                +" has released lock.");


        lock.unlock();
    }

}
