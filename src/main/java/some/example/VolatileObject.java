package com.home.java.demo.thread;

public class VolatileObject
{
    private int counter=0;
    private volatile int vcounter=0;

    public int getCounter() {
        return counter;
    }

    public int getVcounter() {
        return vcounter;
    }

   public void increaseCounter()
   {
       counter++;
   }
    public void increaseVCounter()
    {
        vcounter++;
    }
    @Override
    public String toString() {
        return "VolatileObject{" +
                "counter=" + counter +
                ", vcounter=" + vcounter +
                '}';
    }
}