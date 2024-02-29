package multi.threading.app.demo;

public class ThreadLocalBasicExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=
                                new ThreadLocal<>();
        Thread thread1=new Thread(()->{
            threadLocal.set("thread 1");
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e);
            }
            String value=threadLocal.get();
            System.out.println("Value="+value);
        });
        Thread thread2=new Thread(()->{
            threadLocal.set("thread 2");
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e);
            }
            String value=threadLocal.get();
            System.out.println("Value="+value);
        });
        thread1.start();
        thread2.start();
    }
}
