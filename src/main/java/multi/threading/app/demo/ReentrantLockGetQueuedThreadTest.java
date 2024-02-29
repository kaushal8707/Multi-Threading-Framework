package multi.threading.app.demo;

import java.util.concurrent.locks.ReentrantLock;

class DoCheck{
    ReentrantLock lock;
    DoCheck(ReentrantLock lock){
        this.lock=lock;
    }
    public void doOperation(){
        System.out.println(Thread.currentThread().getName()+"waiting to acquire lock");
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"acquired lock()....");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);}
        System.out.println("Total Thread waiting to acquire lock()..."+lock.getQueueLength());
        lock.unlock();
    }
}
public class ReentrantLockGetQueuedThreadTest {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        DoCheck check=new DoCheck(lock);
        new Thread(()->{
            check.doOperation();
        },"Thread-1").start();
        new Thread(()->{
            check.doOperation();
        },"Thread-2").start();
        new Thread(()->{
            check.doOperation();
        },"Thread-3").start();

    }
}
