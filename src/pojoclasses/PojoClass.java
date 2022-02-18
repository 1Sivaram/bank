package pojoclasses;

import java.io.IOException;

//6th
public class PojoClass 
{
	private String name;
	private int age;
	
	
	public PojoClass() throws IOException
	{
		System.out.println("Default constructor");
		throw new IOException("hi");
	}
	
	public PojoClass(String name,int age)
	{
		System.out.println("Overloaded constructor");
		setName(name);
		setAge(age);
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public String toString()
	{
		return "Name : "+name+", Age : "+age;
	}
}
