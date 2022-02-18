package thread;

public class RunnerThread implements Runnable
{
	
	private long time;
	private boolean flag;
	
	public RunnerThread()
	{
		
	}
	
	public RunnerThread(long time)
	{
		this.time=time;
		flag=true;
	}
	
	public void toggle()
	{
		flag=false;
	}
	
	public void run()
	{
		while(flag)
		{
			System.out.println("Thread Name is : "+ExtendedThread.currentThread().getName());
			System.out.println("Thread Priority is : "+ExtendedThread.currentThread().getPriority());
			System.out.println("Thread State is : "+ExtendedThread.currentThread().getState());
			
			try 
			{
				System.out.println("Going sleep "+ExtendedThread.currentThread().getName());
				Thread.sleep(time);
				System.out.println("After sleep "+ExtendedThread.currentThread().getName());
			} 
			catch (InterruptedException e)
			{
				//e.printStackTrace();
			}
		}
	}
}
