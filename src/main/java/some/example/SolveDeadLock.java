package com.home.java.demo.thread;
class Test3 implements Runnable
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

class Test4 implements Runnable
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
                System.out.println(Thread.currentThread().getName()+" acquired lock on String class");
            }
        }
    }
}


public class SolveDeadLock
{
    public static void main(String[] args) {

        Thread t1=new Thread(new Test3(),"first_Thread");
        t1.start();

        Thread t2=new Thread(new Test4(),"second_Thread");
        t2.start();
    }
}
