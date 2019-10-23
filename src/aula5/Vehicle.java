package aula5;

public class Vehicle implements Comparable<Vehicle>
{
	private int year;
	private String color;
	private int wheels;
	
	public Vehicle(int year, String color, int wheels) 
	{
		this.year = year;
		this.color = color;
		this.wheels = wheels;
	}

	public String getColor() 
	{
		return color;
	}
	
	public void setColor(String color) 
	{
		this.color = color;
	}
	
	public int getYear() 
	{
		return year;
	}

	public int getWheels() 
	{
		return wheels;
	}
	
	@Override
	public String toString() {
		return "[year=" + year + ", color=" + color + ", wheels=" + wheels + "]";
	}
	
	public int compareTo(Vehicle v)
	{
		if(this.getYear() > v.getYear())
		{
			return 1;
		}
		else if(this.getYear() == v.getYear())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}
