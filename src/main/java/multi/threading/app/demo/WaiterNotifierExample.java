package multi.threading.app.demo;

class Message{
    String msg;
    Message(String msg){
        this.msg=msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class Waiter implements Runnable{
    private Message msg;
    Waiter(Message msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  waiting for a messages at time: "+System.currentTimeMillis());
        synchronized (msg){
            try {
                msg.wait();
            }catch (Exception e){System.out.println(e);}
            System.out.println("Waiter got notified at time : "+System.currentTimeMillis());
            System.out.println("Received Message - "+msg.getMsg());
        }
    }
}
class Notifier implements Runnable{

    private Message msg;
    Notifier(Message msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  Notifier started at time: "+System.currentTimeMillis());
        synchronized (msg){
            msg.setMsg("Notifier work done");
            //msg.notify();
            msg.notifyAll();
        }
    }
}

public class WaiterNotifierExample {
    public static void main(String[] args) {
    Message message=new Message("process it");
    Waiter waiter=new Waiter(message); //I create 2 waiter Thread to check notifyAll behavior
    new Thread(waiter,"waiter").start();

    Waiter waiter1=new Waiter(message);
    new Thread(waiter1,"waiter1").start();

    Notifier notifier=new Notifier(message);
    new Thread(notifier,"notifier").start();

    }
}
