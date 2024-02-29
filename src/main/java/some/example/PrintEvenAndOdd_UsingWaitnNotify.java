package com.home.java.demo.thread;
class Even implements Runnable
{
    Odd odd;
    public Even(Odd odd) {
        this.odd = odd;
    }

    @Override
    public void run() {
        synchronized (this.odd) {
            for (int i = 1; i <= 10; i++) {
                if (i%2==0) {
                    System.out.println(i + " ");
                }
            }
            this.odd.notify();
        }
    }
}


class Odd implements Runnable
{
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("odd is in waiting state");
            try {
                this.wait();
            }catch (InterruptedException  e){e.printStackTrace();}
            System.out.println("odd is released from waiting state");
            for (int i = 1; i <= 10; i++) {
                if (i%2!=0) {
                    System.out.println(i + " ");
                }
            }
        }
    }
}


public class PrintEvenAndOdd_UsingWaitnNotify
{
    public static void main(String[] args) throws InterruptedException{
    Odd odd=new Odd();
    Thread thread_odd=new Thread(odd,"Odd_Thread");
    thread_odd.start();

    Even even=new Even(odd);
    Thread thread_even=new Thread(even,"Even_Thread");
    //Thread.sleep(1600);
    thread_even.start();
    }
}
