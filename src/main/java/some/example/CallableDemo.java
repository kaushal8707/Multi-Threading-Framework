package org.example;

import java.util.concurrent.*;

class Cube implements Runnable
{
    Integer num;
    public Cube(Integer num)
    {
        this.num=num;
    }

    @Override
    public void run()  {
        int cube=num*num*num;
        System.out.println(" C u b e  - "+cube);
    }
}

class Square implements Callable<Integer>
{
    Integer num;
    public Square(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int square=num*num;
        return square;
    }
}

public class CallableDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int no_of_threads=3;
        ExecutorService executorService=Executors.newFixedThreadPool(no_of_threads);

        Future<Integer> square_num=executorService.submit(new Square(5));
        System.out.println(" S q u a r e  - "+square_num.get());

        executorService.execute(new Cube(5));
        executorService.shutdown();

    }
}
