package multi.threading.app.demo;

import java.util.concurrent.locks.ReentrantLock;

class Operations{
    ReentrantLock lock;
    Operations(ReentrantLock lock){
        this.lock=lock;
    }
    public void serviceCall(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" acquired lock()...");
        System.out.println(" getHoldCount: "+lock.getHoldCount());
        System.out.println(Thread.currentThread().getName()+" writing business logic");
        try{Thread.sleep(2000);}catch (Exception e){
            System.out.println(e);}
        System.out.println(Thread.currentThread().getName()+" done writing business logic");
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" acquired lock()...");
        System.out.println(" getHoldCount: "+lock.getHoldCount());
        doOperation();
    }
    public void doOperation(){
        System.out.println(Thread.currentThread().getName()+" performing db operation");
        try{Thread.sleep(3000);}catch (Exception e){
            System.out.println(e);}
        System.out.println(Thread.currentThread().getName()+" done performing db operation");
        lock.unlock();
        System.out.println(Thread.currentThread().getName()+" releasing lock()...");
        System.out.println(" getHoldCount: "+lock.getHoldCount());
        lock.unlock();
        System.out.println(Thread.currentThread().getName()+" releasing lock()...");
        System.out.println(" getHoldCount: "+lock.getHoldCount());
    }
}
public class ReentrantMultipleLock {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        Operations operation=new Operations(lock);
        new Thread(()->{
            operation.serviceCall();
        },"Thread-1").start();
        new Thread(()->{
            operation.serviceCall();
        },"Thread-2").start();
    }
}
