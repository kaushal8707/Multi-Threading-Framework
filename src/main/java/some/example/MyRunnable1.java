package com.home.java.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable1 implements Runnable
{
    CyclicBarrier cyclicBarrier;

    MyRunnable1(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() +
                " is waiting for all other threads to reach common barrier point");
        try {
            Thread.sleep(1000);
            /*
             * when all 3 parties will call await() method (i.e. common barrier point)
             * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
             */
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("As all threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");
    }

}
