package com.home.java.demo.thread;
import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable
{
    CountDownLatch countDownLatch;

    MyRunnable(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }


    public void run(){
        
        for(int i=2;i>=0;i--){

            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+
                    " has reduced latch count to : "+ i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
