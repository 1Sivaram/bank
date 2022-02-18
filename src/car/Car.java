package car;

public class Car
{
	private int yearOfMake;
	private String engineNumber;
	private String type;
	
	public Car()
	{
		
	}
	
	public Car(String input)
	{
		System.out.println(input);
	}
	
	public int getYearOfMake() {
		return yearOfMake;
	}
	public void setYearOfMake(int yearOfMake) {
		this.yearOfMake = yearOfMake;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void maintenance()
	{
		System.out.println("Car under Maintenance");
	}
	
	
	
	
//	@Override
//	public String toString() {
//		return "yearOfMake=" + yearOfMake + ", engineNumber="
//				+ engineNumber + ", type=" + type ;
//	}
	
}

