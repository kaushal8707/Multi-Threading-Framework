package multi.threading.app.demo;

public class DeadLockFormation_Synchronized {
    public static void main(String[] args) throws InterruptedException {
        String resource1="resource 1";
        String resource2="resource 2";
        DeadLockFormation_Synchronized obj=new DeadLockFormation_Synchronized();
        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" waiting to acquire lock on resource 1");
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on resource 1");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName()+" waiting to acquire lock on resource 2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on resource 2");
                }
            }
        },"Thread 1");
        Thread t2=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" waiting to acquire lock on resource 2");
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on resource 2");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName()+" waiting to acquire lock on resource 1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on resource 1");
                }
            }
        },"Thread 2");
        t1.start();
        t1.join();
        t2.start();
    }
}
