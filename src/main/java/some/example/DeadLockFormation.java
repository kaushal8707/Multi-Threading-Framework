package com.home.java.demo.thread;

public class DeadLockFormation
{
    public static void main(String[] args) {

        Thread t1=new Thread(new Test1(),"first_Thread");
        t1.start();

        Thread t2=new Thread(new Test2(),"second_Thread");
        t2.start();
    }
}
