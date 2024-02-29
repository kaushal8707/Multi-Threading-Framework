package com.home.java.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Print implements Runnable
{
    int number;
    Print(int number)
    {
        this.number=number;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started...");
        System.out.println(new Track(number));
        System.out.println(Thread.currentThread().getName()+" ended...");


    }
}
public class ExecutorServiceExample
{
    public static void main(String[] args) {

        int no_threads=3;
        int no_task=10;
        ExecutorService service= Executors.newFixedThreadPool(no_threads);
        for(int i=0;i<no_task;i++)
        {
            service.execute(new Print(i));
        }
    }
}
