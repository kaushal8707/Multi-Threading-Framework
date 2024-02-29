package com.home.java.demo.thread;

import java.util.concurrent.locks.Lock;

public class MyRunnable3 implements Runnable
{
    Lock lock;
    public MyRunnable3(Lock lock) {
        this.lock=lock;
    }

    public void run(){

        System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire lock");

        if(lock.tryLock()){
            System.out.println(Thread.currentThread().getName()
                    +" has acquired lock.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else{
            System.out.println(Thread.currentThread().getName()
                    +" didn't got lock.");

        }
    }

}
