package runnerthread;

import task3.Input;
import thread.ExtendedThread;
import thread.RunnerThread;

public class ThreadRunner 
{
	Input inputObj=new Input();
	RunnerThread runnableObj=new RunnerThread();
	ExtendedThread threadObj=new ExtendedThread();
	
	private void case1()
	{
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		System.out.println("Thread Priority is : "+Thread.currentThread().getPriority());
		System.out.println("Thread State is : "+Thread.currentThread().getState());
		System.out.println("Start");
		threadObj.start();
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		System.out.println("Thread Priority is : "+Thread.currentThread().getPriority());
		System.out.println("Thread State is : "+Thread.currentThread().getState());
	}
	
	private void case2()
	{
		Thread thread1=new Thread(runnableObj);
		//Thread thread2=new Thread(runnableObj);
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		System.out.println("Thread Priority is : "+Thread.currentThread().getPriority());
		System.out.println("Thread State is : "+Thread.currentThread().getState());
		System.out.println("Start");
		thread1.start();
	//	thread2.start();
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		System.out.println("Thread Priority is : "+Thread.currentThread().getPriority());
		System.out.println("Thread State is : "+Thread.currentThread().getState());
	}
	
	private void case3()
	{
		;
		System.out.println("Enter thread name(ExtendedThread)");
		String name=inputObj.getString();
		threadObj.setName(name);
		
		System.out.println("Enter thread name(RunnableThread)");
		name=inputObj.getString();
		Thread thread=new Thread(runnableObj,name);
		//thread.setName(name+" ExtendedThread ");
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		System.out.println("Thread Priority is : "+Thread.currentThread().getPriority());
		System.out.println("Thread State is : "+Thread.currentThread().getState());
		System.out.println("Start");
		threadObj.start();
		thread.start();
		System.out.println("Thread Name is : "+Thread.currentThread().getName());
		System.out.println("Thread Priority is : "+Thread.currentThread().getPriority());
		System.out.println("Thread State is : "+Thread.currentThread().getState());
	}
	
	
	private void case4()
	{
		System.out.println("How many threads you want");
		int number=inputObj.getInt();
		
		System.out.println("Enter sleep time for thread(ExtendedThread)");
		long time=inputObj.getLong();
		for(int index=0;index<number;index++)
		{
			ExtendedThread thread=new ExtendedThread(time);
			System.out.println("Enter thread name(ExtendedThread)");
			String name=inputObj.getString();
			thread.setName(name+" ExtendedThread "+index);
			thread.start();
		}
		
		System.out.println("Enter sleep time for thread(RunnableThread)");
		time=inputObj.getLong();
		for(int index=0;index<number;index++)
		{
			System.out.println("Enter thread name(RunnableThread)");
			String name1=inputObj.getString();
			RunnerThread runnableObj=new RunnerThread(time);
			Thread thread1=new Thread(runnableObj,name1+" RunnableThread "+index);
			thread1.start();
		}
	}
	
	private void case5()
	{
		System.out.println("How many threads you want");
		int number=inputObj.getInt();
		
		
		for(int index=0;index<number;index++)
		{
			System.out.println("Enter sleep time for thread(ExtendedThread)");
			long time=inputObj.getLong();
			ExtendedThread thread=new ExtendedThread(time);
			System.out.println("Enter thread name(ExtendedThread)");
			String name=inputObj.getString();
			thread.setName(name+" ExtendedThread "+index);
			thread.start();
		}
		
		for(int index=0;index<number;index++)
		{
			System.out.println("Enter sleep time for thread(ExtendedThread)");
			long time=inputObj.getLong();
			System.out.println("Enter thread name(RunnableThread)");
			String name1=inputObj.getString();
			RunnerThread runnableObj=new RunnerThread(time);
			Thread thread1=new Thread(runnableObj,name1+" RunnableThread "+index);
			thread1.start();
		}
	}
		
		private void case6()
		{
			System.out.println("How many threads you want");
			int number=inputObj.getInt();
			
			for(int index=0;index<number;index++)
			{
				ExtendedThread thread=new ExtendedThread(10000);
				thread.setName(" ExtendedThread "+index);
				thread.start();
				
				RunnerThread runnableObj=new RunnerThread(10000);
				Thread thread1=new Thread(runnableObj," RunnableThread "+index);
				thread1.start();
			}
		}
		
		private void case7()
		{
			System.out.println("How many threads you want");
			int number=inputObj.getInt();
			
			ExtendedThread [] extendArray=new ExtendedThread[number];
			RunnerThread [] runArray=new RunnerThread[number];
			Thread [] threadArray=new Thread[number];
			
			for(int index=0;index<number;index++)
			{
				extendArray[index]=new ExtendedThread(20000);
				extendArray[index].setName("ExtendedThread "+index);
				extendArray[index].start();
				
				runArray[index]=new RunnerThread(15000);
				threadArray[index]=new Thread(runArray[index],"RunnableThread "+index);
				threadArray[index].start();
			}
			
			try 
			{
				Thread.sleep(30000);
			} 
			catch (InterruptedException e)
			{}
			
			for(int index=0;index<number;index++)
			{
				extendArray[index].toggle();
				try 
				{
					Thread.sleep(10000);
					System.out.println("\n"+"   Stop (extend)    "+index+"\n");
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				
				
				runArray[index].toggle();
				
				try 
				{
					Thread.sleep(10000);
					System.out.println("\n"+"   Stop (runnable)    "+index+"\n");
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	
	public static void main(String[] args) 
	{
		ThreadRunner runner=new ThreadRunner();
		Input inputObj=new Input();
		System.out.println("Enter your choice");
		int choice=inputObj.getInt();
		
		switch(choice)
		{
		case 1:
			runner.case1();
			break;
			
		case 2:
			runner.case2();
			break;
			
		case 3:
			runner.case3();
			break;
			
		case 4:
			runner.case4();
			break;
			
		case 5:
			runner.case5();
			break;
			
		case 6:
			runner.case6();
			break;
			
		case 7:
			runner.case7();
			System.out.println("Task completed");
			break;
			
		}
	}

}
