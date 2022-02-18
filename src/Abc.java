

abstract class Aoo
{
	public Aoo()
	{
		
	}
	
	public Aoo(String a)
	{
	
	}
	public Object show()
	{
		return null;
	}
}


class Boo extends Aoo
{
	public Boo ()
	{
		//super("sf");
	}
}

public class Abc {

	public static void main(String[] args)
	{
		Aoo obj=new Boo();
		System.out.println(obj.show());
	}

}