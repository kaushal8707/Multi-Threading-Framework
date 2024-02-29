package com.home.java.demo.thread;

import java.util.Date;

public class ThreadLocalUsage
{
    public static class MyRunnable implements Runnable {
        private ThreadLocal<String> threadLocal =   new ThreadLocal<String>();

        @Override
        public void run() {

            threadLocal.set(new Date().toString());

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) { e.printStackTrace();    }

            System.out.println(Thread.currentThread().getName()+
                    " start time = "+threadLocal.get());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable,"Thread-1");
        Thread thread2 = new Thread(myRunnable,"Thread-2");
        thread1.start();
        Thread.sleep(1000); //Start thread-2 after 1 second.
        thread2.start();
    }

}
