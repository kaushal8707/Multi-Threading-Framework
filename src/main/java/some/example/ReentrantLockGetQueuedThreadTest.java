package com.home.java.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockGetQueuedThreadTest
{
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        MyRunnable4 myRunnable=new MyRunnable4(lock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();
        new Thread(myRunnable,"Thread-3").start();

    }

}
