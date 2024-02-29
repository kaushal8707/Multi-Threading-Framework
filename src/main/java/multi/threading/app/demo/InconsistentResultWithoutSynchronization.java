package multi.threading.app.demo;
class TableDemo{
    public void printValue(int input){
        for(int i=1;i<=5;i++){
            System.out.println(input*i);
            try {
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
public class InconsistentResultWithoutSynchronization {
    public static void main(String[] args) {
        TableDemo td=new TableDemo(); // only one object shared among both of the threads
                                        // getting inconsistent results 2,4,5,10,6,15,8,10,20,25...
        new Thread(()->{
            td.printValue(2);
        }).start();

        new Thread(()->{
            td.printValue(5);
        }).start();
    }
}
