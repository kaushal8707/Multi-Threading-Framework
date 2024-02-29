package multi.threading.app.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource1{
    Lock lock;
    Resource1(Lock lock){
        this.lock=lock;
    }
    public void accessResource(){
        System.out.println(Thread.currentThread().getName()+" is waiting for lock()...");
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" is acquired lock()...");

        try {
            Thread.sleep(100);
        }catch (Exception e){
            System.out.println(e);}
        System.out.println(Thread.currentThread().getName()+" is going to release lock()...");
        lock.unlock();
    }
}
public class  ReentrantLockTest  {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
      new Thread(()->{
        new Resource1(lock).accessResource();
      },"Thread 1").start();
        new Thread(()->{
            new Resource1(lock).accessResource();
        },"Thread 2").start();
    }
}
