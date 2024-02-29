package multi.threading.app.demo;

import java.util.ArrayList;
import java.util.List;

class Producer1 implements Runnable{
    List<String> list;
    Producer1(List<String> list){
        this.list=list;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Producer started producing.....");
        synchronized (list){
            for(int i=1;i<=5;i++){
                list.add("product - "+i);
            }
            System.out.println("Done Producing...!!");
            list.notify();
        }
    }
}
class Consumer1 implements Runnable{
    List<String> list;
    Consumer1(List<String> list){
        this.list=list;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if(list.isEmpty()){
            System.out.println("consumer waiting for producer to produce...");
        }
        synchronized (list){
            try {
                list.wait();
            }catch (Exception e){System.out.println(e);}
            System.out.println("Consumer Started Consuming..... ");
            if(!list.isEmpty()){
                for(String i:list){
                    System.out.println(i);
                }
            }
            System.out.println("Done Consuming...!!");
        }
    }
}
public class ProducerConsumerProblemSolved {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();//we are sharing the same object to both of the threads...
        Consumer1 consumer1=new Consumer1(list);
        Producer1 producer1=new Producer1(list);
        new Thread(consumer1,"consumer").start();
        Thread.sleep(100);
        new Thread(producer1,"producer").start();
    }
}
