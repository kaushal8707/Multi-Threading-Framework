package multi.threading.app.demo;

import java.util.concurrent.locks.*;

public class DeadLockFormation_ReentrantLock {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    String resource1 = "i am resource 1";
    String resource2 = "i am resource 2";
    public static void main(String[] args) {
        DeadLockFormation_ReentrantLock access=new DeadLockFormation_ReentrantLock();
        new Thread(() -> {
               access.accessResource1();
        },"Thread 1").start();
        new Thread(() -> {
                access.accessResource2();
        }, "Thread 2").start();
    }
        public void accessResource1(){
            lock1.lock();
            System.out.println(Thread.currentThread().getName()+" acquired lock on resource 1");
            System.out.println(resource1);
            try{Thread.sleep(2000);}catch (Exception e){
                System.out.println(e);}
            System.out.println(Thread.currentThread().getName()+" trying to acquire lock on resource 2");
            lock2.lock();
            lock1.unlock();
            lock2.unlock();
        }
        public void accessResource2(){
            lock2.lock();
            System.out.println(Thread.currentThread().getName()+" acquired lock on resource 2");
            System.out.println(resource2);
            try{Thread.sleep(2000);}catch (Exception e){
                System.out.println(e);}
            System.out.println(Thread.currentThread().getName()+" trying to acquire lock on resource 1");
            lock1.lock();
            lock2.unlock();
            lock1.unlock();
        }
}
