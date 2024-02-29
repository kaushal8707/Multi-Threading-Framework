package com.home.java.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest
{
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        MyRunnable2 myRunnable=new MyRunnable2(lock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();

    }

}
