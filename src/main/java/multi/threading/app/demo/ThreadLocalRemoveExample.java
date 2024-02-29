package multi.threading.app.demo;

public class ThreadLocalRemoveExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new ThreadLocal<>();
        new Thread(()->{
            threadLocal.set("thread1");
            try{Thread.sleep(1000);}catch (Exception e){
                System.out.println(e);}
            System.out.println(Thread.currentThread().getName()+" get()- "+threadLocal.get());
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName()+" get()- "+threadLocal.get());
        },"thread-1").start();
        new Thread(()->{
            threadLocal.set("thread2");
            try{Thread.sleep(1000);}catch (Exception e){
                System.out.println(e);}
            System.out.println(Thread.currentThread().getName()+" get()- "+threadLocal.get());
            System.out.println(Thread.currentThread().getName()+" get()- "+threadLocal.get());
        },"thread-2").start();
    }

}
