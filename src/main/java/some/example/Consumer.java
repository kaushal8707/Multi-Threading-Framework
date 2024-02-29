package com.home.java.demo.thread;

import java.util.List;

public class Consumer implements Runnable
{
	List<Integer> list;
	public Consumer(List<Integer> list)
	{
		this.list=list;
	}
	@Override
	public void run()
	{
		synchronized (this) 
		{
		  try {
			  System.out.println(Thread.currentThread().getName()+"   waiting to complete production by producer ."); 
			  this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  System.out.println(Thread.currentThread().getName()+"   is Ready to Consume. . . ");

		  for(Integer i:list)
		  {
			  System.out.println("Consumed  "+i+"  ");
		  } 
		  System.out.println("consumer end .");
		  
		}
	}

}
