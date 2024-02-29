
package com.home.java.demo.thread;
class Test5 implements Runnable
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

class Test6 implements Runnable
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


public class SolveDeadLockUsingJoin
{
    public static void main(String[] args) throws InterruptedException{

        Thread t1=new Thread(new Test5(),"first_Thread");
        t1.start();
        t1.join();
        Thread t2=new Thread(new Test6(),"second_Thread");
        t2.start();
    }
}
