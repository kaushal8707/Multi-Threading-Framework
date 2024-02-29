package com.home.java.demo.thread;

public class Test1 implements Runnable
{
    @Override
    public void run()
    {
        synchronized (String.class)
        {
            System.out.println(Thread.currentThread().getName()+" acquired lock on String class and trying to acquire lock on Object class");
            try{Thread.sleep(1200);}catch (Exception e){e.printStackTrace();}
            synchronized (Object.class)
            {
                System.out.println(Thread.currentThread().getName()+" acquired lock on Object class");
            }
        }
    }
}
