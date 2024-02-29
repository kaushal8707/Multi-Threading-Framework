package multi.threading.app.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MultipleOperation{
    Lock lock;
    MultipleOperation(Lock lock){
        this.lock=lock;
    }
    public void dbOperation() throws InterruptedException {
        long startTime=System.currentTimeMillis();
        if(lock.tryLock(10, TimeUnit.SECONDS)) {
            System.out.println(Thread.currentThread().getName() + "start performing database operation.....");
            try {
                Thread.sleep(15000);
            } catch (Exception e) {
                System.out.println(e);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "  end db operation" + "Total Time took for DB" + ((endTime - startTime) / 1000) + " seconds");
        }
        loggingOperation();
    }
    public void loggingOperation(){
        System.out.println(Thread.currentThread().getName()+"  start performing logging Operation");
        System.out.println(Thread.currentThread().getName()+"  end performing logging Operation");
    }
}
public class ReentrantLockDbAndLoggingOperation {
    public static void main(String[] args) {
    Lock lock=new ReentrantLock();
    MultipleOperation operation=new MultipleOperation(lock);
    new Thread(()->{
        try {
            operation.dbOperation();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    },"Thread-1").start();
        new Thread(()->{
            try {
                operation.dbOperation();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread-2").start();}}
