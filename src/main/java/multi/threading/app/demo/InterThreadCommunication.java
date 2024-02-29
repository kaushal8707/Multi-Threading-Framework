package multi.threading.app.demo;
class Person
{
    int amount =500;
    synchronized public void deposit(int amount){
        System.out.println("amount deposited in account: ");
        this.amount+=amount;
        System.out.println("After Deposit total balance - "+(this.amount+=amount));
        notify();
    }
    synchronized public void withdraw(int amount) {
       if(this.amount<amount){
           System.out.println("Not sufficient balance !! waiting for deposit...");
           try {
               wait();
           }catch (Exception e){
               System.out.println(e);}
       }
       this.amount-=amount;
       System.out.println("withdraw completed..."+"  current Balance is : "+(this.amount-=amount));
    }
}
public class InterThreadCommunication {
    public static void main(String[] args) {
        Person p=new Person();
        new Thread(()->{
          p.withdraw(600);
        }).start();
        new Thread(()->{
            p.deposit(200);
        }).start();
    }
}