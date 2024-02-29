package multi.threading.app.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Operation{
    Lock lock;
    Operation(Lock lock){
        this.lock=lock;
    }
    public void doOperation(){
        if(lock.tryLock()){
            System.out.println(Thread.currentThread().getName()+" get the Lock....");
            System.out.println("performing operation...");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);}
        }else{
            System.out.println(Thread.currentThread().getName()+" didn't get the Lock....");
        }}}
public class ReentrantLockTryLockTest {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Operation operation=new Operation(lock);
        new Thread(()->{
            operation.doOperation();
        },"Thread-1").start();
        new Thread(()->{
            operation.doOperation();
        },"Thread-2").start();
        new Thread(()->{
            operation.doOperation();
        },"Thread-3").start();
        new Thread(()->{
            operation.doOperation();
        },"Thread-4").start();
    }
}
