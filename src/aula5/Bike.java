package aula5;

public class Bike extends Vehicle
{
	public Bike(int year, String color, int wheels) 
	{
		super(year, color, wheels);
	}

	@Override
	public String toString() {
		return "Bike -> " + super.toString();
	}
}
