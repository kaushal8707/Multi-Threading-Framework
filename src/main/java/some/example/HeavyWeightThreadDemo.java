package com.home.java.demo.thread;
class Task1 implements Runnable
{
    @Override
    public void run() {
    for(int i=0;i<10;i++)
    {
        System.out.println(i+" "+Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        }catch (InterruptedException exc)
        {
            exc.printStackTrace();
        }
    }
    }
}
class Task2 implements Runnable
{
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            System.out.println(i+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            }catch (InterruptedException exc)
            {
                exc.printStackTrace();
            }
        }
    }
}
public class HeavyWeightThreadDemo
{
    public static void main(String[] args) {
        Thread t1=new Thread(new Task1(),"thread-1");
        Thread t2=new Thread(new Task2(),"thread-2");
        t1.start();
        t2.start();


    }
}
