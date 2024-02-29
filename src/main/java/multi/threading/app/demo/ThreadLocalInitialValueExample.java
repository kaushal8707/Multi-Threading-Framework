package multi.threading.app.demo;
class MyObject{
}
public class ThreadLocalInitialValueExample {
    public static void main(String[] args) {
        ThreadLocal<MyObject> threadLocal1 = new ThreadLocal<MyObject>() {
            @Override
            protected MyObject initialValue() {
                return new MyObject();
            }};
        ThreadLocal<MyObject> threadLocal2 = ThreadLocal.withInitial(() -> {
            return new MyObject();
        });
        Thread thread1=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" thread local 1 - "+threadLocal1.get());
            System.out.println(Thread.currentThread().getName()+" thread local 2 - "+threadLocal2.get());
        });
        Thread thread2=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" thread local 1 - "+threadLocal1.get());
            System.out.println(Thread.currentThread().getName()+" thread local 2 - "+threadLocal2.get());
        });
        thread1.start();
        thread2.start();
    }}
