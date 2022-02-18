package singletonclass;


public enum Singleton implements Cloneable
{
	INSTANCE;
	
	public static void main(String args[]) 
	{
		Singleton obj=Singleton.INSTANCE;
		System.out.println(obj.hashCode());
		try
		{
		Singleton obj1=(Singleton)obj.clone();
		System.out.println(obj1.hashCode());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}


