package com.home.java.demo.thread;

public class Test2 implements Runnable
{
    @Override
    public void run()
    {
        synchronized (Object.class)
        {
            System.out.println(Thread.currentThread().getName()+" acquired lock on Object class and trying to acquire lock on String class");
            try{Thread.sleep(1200);}catch (Exception e){e.printStackTrace();}
            synchronized (String.class)
            {
                System.out.println(Thread.currentThread().getName()+" acquired lock on String class");
            }
        }
    }
}
