package multi.threading.app.demo;

import java.util.ArrayList;
import java.util.List;


class Product{
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
class ProductFactory{
    List<Product> list;
    ProductFactory(List<Product> list){
        this.list=new ArrayList<>();
    }
    public void produce(){
        System.out.println("producer started the producing product....");

        for(int i=0;i<5;i++){
            System.out.println("producing...."+"Product "+i);
            list.add(new Product("product"+i,i));
        }
        System.out.println("producer done the producing product....");
    }
    public void consume(){
        System.out.println("Consumer start consuming....");
        if(!list.isEmpty()){
            list.stream().forEach(System.out::println);
        }
        System.out.println("All products consumed...!!");
    }}
class Producer implements Runnable{
    ProductFactory productFactory;

    public Producer(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName());
        synchronized (productFactory) {
            productFactory.produce();
            productFactory.notify();
        }
    }
}

class Consumer implements Runnable{
    ProductFactory productFactory;

    public Consumer(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" waiting to consume....");
        synchronized (productFactory) {
            try {
                productFactory.wait();
            }catch (Exception e){
                System.out.println(e);}
            System.out.println("started consuming products...");
            productFactory.consume();
            System.out.println("Consumed all products...");
        }
    }
}
public class ConsumerProducerProblem {
    public static void main(String[] args) {
        List<Product> l=null;
        ProductFactory productFactory=new ProductFactory(l);
        Producer p=new Producer(productFactory);
        Consumer c=new Consumer(productFactory);

        new Thread(c,"consumer").start();
        new Thread(p,"producer").start();

    }
}
