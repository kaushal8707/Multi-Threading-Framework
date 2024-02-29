package multi.threading.app.demo;

public class YieldMethodTest {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for(int i=1;i<=5;i++){
                    Thread.yield();
                System.out.println(Thread.currentThread().getName()+"-> "+i);
            }
            System.out.println(Thread.currentThread().getName()+" stop running.....");
        });
        t1.start();

        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+"  process -"+i);
        }
        System.out.println(Thread.currentThread().getName()+" stop running.....");
    }
}
