package com.home.java.demo.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest
{
    public static void main(String[] args) {
    CountDownLatch countDownLatch=new CountDownLatch(3);
          System.out.println("CountDownLatch has been created with count=3");

          new Thread(new MyRunnable(countDownLatch),"Thread-1").start();

          try {
                countDownLatch.await();
              } catch (InterruptedException e) {
                     e.printStackTrace();
              }
                  System.out.println("count has reached zero, "+
                  Thread.currentThread().getName()+" thread has ended");
}

}
