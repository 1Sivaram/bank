package xuv;

import car.Car;

public class XUV extends Car
{
	private int seats;
	private int airbags;
	private String colour;
	private String model;
	
	public XUV()
	{
		super("Overloaded");
	}
	public int getSeats() 
	{
	return seats;
	}
	public void setSeats(int seats)
	{
		this.seats = seats;
	}
	public int getAirbags()
	{
		return airbags;
	}
	public void setAirbags(int airbags) 
	{
		this.airbags = airbags;
	}
	public String getColour() 
	{
		return colour;
	}
	public void setColour(String colour) 
	{
		this.colour = colour;
	}
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	
//		@Override
//		public String toString()
//		{
//			return "Number of seats= " + seats + ", Number of airbags= " + airbags
//			+ ", Car colour= "+ colour + ", Car model= " + model;
//		}
}
