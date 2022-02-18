package enumclass;
import task3.Input;
//import singletonclass.Singleton;

enum Colour
{
	VIOLET,INDIGO,BLUE,GREEN,YELLOW,ORANGE,RED;
	
	public static int getColourCode(Colour obj)
	{
		int colourCode=obj.ordinal();
		return colourCode+1;
	}
}


public class ColourRunner
{
	public static void main(String []args)
	{
		Input objInput=new Input();
		Colour [] colourArray=Colour.values();
		
		for(Colour color:colourArray)
		{
			System.out.println("Colour Name : "+color.name());
		}
		System.out.println("Enter your choice");
		
		int choice=objInput.getInt();
		if(choice<8&&choice>0)
		{
		System.out.println("Your choice is : "+colourArray[choice-1]+
		"\n"+"Colour code of "+colourArray[choice-1].name()+" is "+Colour.getColourCode(colourArray[choice-1]));
		}
		else
		{
			System.out.println("Enter valid choice");
		}
	}
}