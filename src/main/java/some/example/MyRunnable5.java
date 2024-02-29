package com.home.java.demo.thread;

import java.util.concurrent.locks.Lock;

public class MyRunnable5 implements Runnable
{
    Lock lock;
    public MyRunnable5(Lock lock) {
        this.lock=lock;
    }

    public void run(){

        System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire lock");

        lock.lock();
        System.out.println();
        System.out.println(Thread.currentThread().getName()
                +" has called lock(), lockHoldCount=1 ");


        lock.lock();
        System.out.println(Thread.currentThread().getName()
                +" has called lock(), lockHoldCount=2 ");

        System.out.println(Thread.currentThread().getName()
                +" is about to call unlock(), lockHoldCount will become 1 ");
        lock.unlock();

        System.out.println(Thread.currentThread().getName()
                +" is about to call unlock(), lockHoldCount will become 0 ");
        lock.unlock();



    }

}
