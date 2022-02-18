package reflectionclass;
import task3.Input;
import java.lang.reflect.*;

public class ReflectionClass 
{
	public static void main(String [] args) 
	{
		Input inputObj=new Input();
		
		try
		{
			Class<?> classObj=Class.forName("pojoclasses.PojoClass");
			
			//8 i 
			//Object obj=classObj.newInstance();
			Object obj=classObj.getDeclaredConstructor().newInstance();
			//8 ii
			Constructor<?> cObj=classObj.getDeclaredConstructor(String.class,int.class);
			System.out.println("Enter your Name");
			String name=inputObj.getString();
			System.out.println("Enter your Age");
			int age=inputObj.getInt();
			Object newObj=cObj.newInstance(name,age);
			System.out.println(newObj);
			
			//8 iii
			Method mObj=classObj.getDeclaredMethod("setName",String.class);
			System.out.println("Enter your Name");
			String nameString=inputObj.getString();
			mObj.invoke(obj, nameString);	
			
			//8 iv
			Method method=classObj.getDeclaredMethod("getName");
			System.out.println("Name is : "+method.invoke(obj));
		} 
		catch (ClassNotFoundException |InstantiationException | IllegalAccessException
				|NoSuchMethodException | SecurityException|IllegalArgumentException | InvocationTargetException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
