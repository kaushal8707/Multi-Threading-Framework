package com.home.java.demo.thread;

public class RunnableAtomic implements Runnable
{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() +"  ");


        System.out.println(AtomicIntegerExample.sharedAtomicInteger.getAndIncrement());
    }
}
