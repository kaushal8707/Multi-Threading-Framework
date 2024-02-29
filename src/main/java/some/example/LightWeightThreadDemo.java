package com.home.java.demo.thread;
class Tasks implements Runnable
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

public class LightWeightThreadDemo {
    public static void main(String[] args) {
        Thread t1=new Thread(new Tasks(),"thread-1");
        Thread t2=new Thread(new Tasks(),"thread-2");
        t1.start();
        t2.start();


    }
}
