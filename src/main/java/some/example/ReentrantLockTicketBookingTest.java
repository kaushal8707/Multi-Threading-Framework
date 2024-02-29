package com.home.java.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTicketBookingTest
{
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        MyRunnable6 myRunnable=new MyRunnable6(lock);
        new Thread(myRunnable,"Passenger1 Thread").start();
        new Thread(myRunnable,"Passenger2 Thread").start();

    }

}
