package multi.threading.app.demo;
class DataTable {
    synchronized static void print(int data) {
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
public class ProblemSolvedWithStaticSynchronizationExample {
    public static void main(String[] args) {

        new Thread(()->{
            DataTable.print(1);
        }).start();
        new Thread(()->{
            DataTable.print(10);
        }).start();
        new Thread(()->{
            DataTable.print(100);
        }).start();
        new Thread(()->{
            DataTable.print(1000);
        }).start();
    }
}
