package aula5;

public class Police extends Motorized
{
	public enum TYPE { INEM, FIREMAN, GNR, PSP, PJ};
	
	public static int ID_BASE = 1;
	private int id;
	private TYPE type;
	
	public Police(int year, String color, int wheels, int displacement, String licensePlate, int maxSpeed, double fuel, int power, int consumption, TYPE type) 
	{
		super(year, color, wheels, displacement, licensePlate, maxSpeed, fuel, power, consumption);
		this.id = Police.ID_BASE++;
		this.type = type;
	}

	public int getId() 
	{
		return id;
	}

	public TYPE getType() 
	{
		return type;
	}

	@Override
	public String toString() {
		return "Police -> " + "[id=" + id + ", type=" + type + "]" + super.toString();
	}
	
	
}
