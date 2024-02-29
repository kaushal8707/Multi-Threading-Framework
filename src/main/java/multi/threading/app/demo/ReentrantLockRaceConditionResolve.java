package multi.threading.app.demo;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PerformOperation{
    int ticketAvailable=1;Lock lock;
    PerformOperation(Lock lock){this.lock=lock;}
    public void bookTicket(){
        System.out.println(Thread.currentThread().getName()+" waiting to book ticket....");
        lock.lock();
        if(ticketAvailable>0){
            System.out.println(Thread.currentThread().getName()+"acquired lock to book ticket");
            System.out.println("Ticket available ="+ticketAvailable);
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e);}
            ticketAvailable--;
            System.out.println(Thread.currentThread().getName()+"Booked Ticket...");
            System.out.println("Available ticket = "+ticketAvailable);
        }else{
            System.out.println(Thread.currentThread().getName()+" not booked ticket"+" ticket avail"+ticketAvailable);
        }
        lock.unlock();
    }
}
public class ReentrantLockRaceConditionResolve {
    public static void main(String[] args) {
    Lock lock=new ReentrantLock();
    PerformOperation operation=new PerformOperation(lock);
    new Thread(()->{
        operation.bookTicket();
    },"Thread 1").start();
        new Thread(()->{
        operation.bookTicket();
        },"Thread 2").start();

    }
}
