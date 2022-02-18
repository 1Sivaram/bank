package carrunner;

import bird.Bird;
import birdabstract.BirdAbstract;
import car.Car;
import duck.Duck;
//import myException.CustomException;
import parrot.ParrotMod;
import scross.SCross;
import swift.Swift;
import task3.Input;
//import validateclass.Checker;
import xuv.XUV;

public class CarRunner 
{
	Swift swift=new Swift();
	SCross sCross=new SCross();
	Car carSwift=new Swift();
	Car carSCross=new SCross();
	XUV xuv=new XUV();
	Car carXUV=new XUV();
	Car carObj=new Car();
	private int number;
	private String string;
	
	
	private void case2(Input obj)
	{
		
		System.out.println("How many airbags you want to set ");
		number=obj.getInt();
		swift.setAirbags(number);
		System.out.println("What colour you want to set");
		string=obj.getString();
		swift.setColour(string);
		System.out.println("What car model you want to set");
		string=obj.getString();
		swift.setModel(string);
		System.out.println("How many car seats you want to set");
		number=obj.getInt();
		swift.setSeats(number);
		System.out.println("Airbags count is : "+swift.getAirbags());
		System.out.println("Car colour is : "+swift.getColour());
		System.out.println("Car moder is : "+swift.getModel());
		System.out.println("Car seats count is : "+swift.getSeats());
	}
	
	
	private void case3(Input obj)
	{
		System.out.println("Engine Number for the Car");
		string=obj.getString();
		sCross.setEngineNumber(string);
		System.out.println("Type for the Car");
		string=obj.getString();
		sCross.setType(string);
		System.out.println("Year of make for the car");
		number=obj.getInt();
		sCross.setYearOfMake(number);
		System.out.println("How many airbags you want to set ");
		number=obj.getInt();
		sCross.setAirbags(number);
		System.out.println("What colour you want to set");
		string=obj.getString();
		sCross.setColour(string);
		System.out.println("What car model you want to set");
		string=obj.getString();
		sCross.setModel(string);
		System.out.println("How many car seats you want to set");
		number=obj.getInt();
		sCross.setSeats(number);
		System.out.println("Car Engine number : "+sCross.getEngineNumber());
		System.out.println("Car type : "+sCross.getType());
		System.out.println("YearOfMake : "+sCross.getYearOfMake());
		System.out.println("Airbags count is : "+swift.getAirbags());
		System.out.println("Car colour is : "+swift.getColour());
		System.out.println("Car moder is : "+swift.getModel());
		System.out.println("Car seats count is : "+swift.getSeats());
	}
	
	
	private void case4(Car object)
	{
		//System.out.println(" Car ");
		if(object instanceof Swift)
		{
			System.out.println("Hatch");
		}
		else if(object instanceof SCross)
		{
			System.out.println("SUV");
		}
		else if(object instanceof XUV)
		{
			System.out.println("Sedan");
		}
		else
		{
			System.out.println("Unregistered");
		}
		
	}
	
	
	private void case5()
	{
		case4(swift);
		case4(sCross);
		case4(xuv);
		case4(carSwift);
		case4(carSCross);
		case4(carXUV);
	}
	
	
	private void case6(Swift swift)
	{
		System.out.println("Inside a Method");
	}
	
	
	private void case7()
	{
		sCross.maintenance();
		carSCross.maintenance();
		carObj.maintenance();
		swift.maintenance();
	}
	
	private void case8()
	{
		XUV xuv=new XUV();
		Car carXUV=new XUV();
	}
	
	private void case9()
	{
		Bird bird=new ParrotMod();
		bird.fly();
		bird.speak();
		ParrotMod parrot=new ParrotMod();
		parrot.fly();
		parrot.speak();
	}
	
	private void case10()
	{
		BirdAbstract duck=new Duck();
		duck.fly();
		duck.speak();
	}
	
	public static void main(String[] args) 
	{
		CarRunner inher=new CarRunner();
		Input inputObj=new Input();
		Swift swift=new Swift();
		//Car carSwift=new Swift();
		Car carObj=new Car();
		System.out.println("Enter your choice");
		int choice=inputObj.getInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Exit");
			break;
			
		case 2:
			inher.case2(inputObj);
			break;
			
		case 3:
			inher.case3(inputObj);
			break;
			
		case 4:
			inher.case4(carObj);
			break;
		
		case 5:
			inher.case5();
			break;
			
		case 6:
			inher.case6(swift);
			break;
			//inher.case6(carSwift);
			//inher.case6(sCross);
			
		case 7:
			inher.case7();
			break;
			
		case 8:
			inher.case8();
			break;
			
		case 9:
			inher.case9();
			break;
			
		case 10:
			inher.case10();
			break;
		default:
			System.out.println("Enter your valid choice");
			break;
		}
		
	}
}
