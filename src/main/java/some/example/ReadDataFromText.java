package com.home.java.demo.thread;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadDataFromText
{
    static AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void main(String[] args) throws FileNotFoundException,IOException {
    ExecutorService service= Executors.newFixedThreadPool(3);
    File file=new File("C:\\kaushal");
    if(!file.exists())
    {
        file.mkdirs();
    }
        FileInputStream fileInputStream=new FileInputStream(file+"\\"+"temp.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(fileInputStream));
        String str="";
        while((str=br.readLine())!=null)
        {
            String data=str+"";
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                System.out.println(atomicInteger.getAndIncrement());
                DataReciever.show(data);
                }
            };
            service.execute(runnable);
        }
        service.shutdown();


    }
}
