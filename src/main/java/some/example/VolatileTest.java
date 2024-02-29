package com.home.java.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest
{
    public static void main(String[] args) throws InterruptedException{

        VolatileObject volatileObject=new VolatileObject();
        VolatileThread volatileThread=new VolatileThread(volatileObject);
        Thread t1=new Thread(volatileThread);
        Thread t2=new Thread(volatileThread);
        Thread t3=new Thread(volatileThread);
        t1.start();
        t2.start();
        t3.start();

    }
}
