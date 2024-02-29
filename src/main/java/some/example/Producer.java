package com.home.java.demo.thread;

import java.util.List;

public class Producer implements Runnable
{
	List<Integer> list;
	Consumer consumer;
	public Producer(Consumer consumer,List<Integer> list)
	{
		this.list=list;
		this.consumer=consumer; 
	}
	@Override
	public void run()
	{
			synchronized (this.consumer) 
			{
				System.out.println(Thread.currentThread().getName()+"  is start production"); 
				for(int i=0;i<=10;i++)
				{
					list.add(i);
					System.out.println(" produced "+i);
				}
				this.consumer.notify();
				
			}
	}

}
