package multi.threading.app.demo;

public class VolatileThreadDemo {
    volatile static boolean flag=true;
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            while(flag){
                System.out.println("MyThread is start processing.....");
            }
            System.out.println("My Thread stop running....");
        },"MyThread");
        thread.start();
        try{
            Thread.sleep(500);
        }catch (Exception e){
            System.out.println(e);
        }
        flag=false;
        System.out.println("Now we are in a main thread....");
    }
}
