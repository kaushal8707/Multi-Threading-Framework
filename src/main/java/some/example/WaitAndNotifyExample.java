package com.home.java.demo.thread;

class Process1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is in waiting state......");
        synchronized (this) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " comes out of waiting state......");

    }
}
class Process2 implements Runnable {
    Process1 process1;

    Process2(Process1 process1) {
        this.process1 = process1;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started......");
        synchronized (this.process1) {
            this.process1.notify();
        }
        System.out.println(Thread.currentThread().getName() + " end......");
    }

}
public class WaitAndNotifyExample
{
    public static void main(String[] args) throws InterruptedException{
    Process1 process1=new Process1();
    Process2 process2=new Process2(process1);
    Thread t1=new Thread(process1);
    Thread t2=new Thread(process2);
    t1.start();
    Thread.sleep(1000);
    t2.start();
    }
}
