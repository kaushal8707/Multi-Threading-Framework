package multi.threading.app.demo;

public class ThreadLocalLazyInitExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=
                            new ThreadLocal<>();
        new Thread(()->{
            String value=threadLocal.get();
            if(value==null){
                threadLocal.set("lazy set value");
                value=threadLocal.get();
            }
            System.out.println(value);
        }).start();
    }
}
