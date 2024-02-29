package multi.threading.app.demo;
class PrintTable {
    synchronized void print(int data) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(data * i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
public class ProblemWithoutStaticSynchronizationExample {
    public static void main(String[] args) {
        PrintTable printTable1=new PrintTable();
        PrintTable printTable2=new PrintTable();

        new Thread(()->{
            printTable1.print(1);      //Thread 1 and Thread 2 is having same object printTable1 reference
        }).start();
        new Thread(()->{
            printTable1.print(10);    //Thread 1 and Thread 2 is having same object printTable1 reference
        }).start();
        new Thread(()->{
            printTable2.print(100);   //Thread 3 and Thread 4 is having same object printTable2 reference
        }).start();
        new Thread(()->{
            printTable2.print(1000);  //Thread 3 and Thread 4 is having same object printTable2 reference
        }).start();
    }
}
