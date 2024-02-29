package com.home.java.demo.thread;
class Even1 implements Runnable
{
    @Override
    public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i%2==0) {
                    System.out.println(i + " ");
                }
            }
    }
}


class Odd1 implements Runnable
{
    @Override
    public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i%2!=0) {
                    System.out.println(i + " ");
                }
            }
        }
    }

public class PrintEvenAndOdd_UsingJoin
{
    public static void main(String[] args) throws InterruptedException{
        Even1 even=new Even1();
        Thread thread_even=new Thread(even,"Even_Thread");
        thread_even.start();
        thread_even.join();

        Odd1 odd=new Odd1();
        Thread thread_odd=new Thread(odd,"Odd_Thread");
        thread_odd.start();


    }
}
