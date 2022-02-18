package pojorunner;
import pojoclasses.PojoClass;

public class PojoRunner 
{
	public static void main(String[] args) 
	{
		
		try
		{
			//6th
			PojoClass pojoObj=new PojoClass("Siva",12);
			System.out.println(pojoObj);
			//7th
			PojoClass objPojo=new PojoClass();
			objPojo.setName("Ram");
			objPojo.setAge(23);
			System.out.println("Name "+objPojo.getName()+", Age "+objPojo.getAge());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
