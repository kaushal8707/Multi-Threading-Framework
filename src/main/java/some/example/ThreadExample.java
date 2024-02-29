package com.home.java.demo.thread;
class Task extends Thread
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"  thread started");
        for(int i=1;i<=10;i++)
       {
           System.out.print(i+"  ");
       }
        System.out.println(Thread.currentThread().getName()+"  thread ended");

    }
}
public class ThreadExample extends Thread
{
    public static void main(String[] args) {
        System.out.println("Main thread started");
        Task t1=new Task();
        t1.start();
        System.out.println("Main thread ended");

    }
}
