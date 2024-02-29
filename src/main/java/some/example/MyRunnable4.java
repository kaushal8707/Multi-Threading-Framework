package com.home.java.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable4 implements Runnable
{
    ReentrantLock lock;
    public MyRunnable4(ReentrantLock lock) {
        this.lock=lock;
    }

    public void run(){

        System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire lock");

        lock.lock();
        System.out.println(Thread.currentThread().getName()
                +" has acquired lock.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>--- getQueueLength = "+lock.getQueueLength()+"---<<<<");

        System.out.println(Thread.currentThread().getName()
                +" has released lock.");

        lock.unlock();    //read explanation for 5sec
    }
}
