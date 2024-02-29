package multi.threading.app.demo;
class Table {
    synchronized void printValue(int num) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i * num);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ConsistentResultsWithSynchronization {
    public static void main(String[] args) {
        Table tb=new Table();
        new Thread(()->{
           tb.printValue(3);
        }).start();

        new Thread(()->{
            tb.printValue(5);
        }).start();
    }
}
