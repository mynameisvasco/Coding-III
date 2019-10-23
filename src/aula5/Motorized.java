package aula5;

public class Motorized extends Vehicle
{
	private int displacement;
	private int power;
	private double consumption;
	private String licensePlate;
	private int maxSpeed;
	private double fuel;
	
	public Motorized(int year, String color, int wheels, int displacement, String licensePlate, int maxSpeed, double fuel, int power, int consumption) 
	{
		super(year, color, wheels);
		this.displacement = displacement;
		this.licensePlate = licensePlate;
		this.maxSpeed = maxSpeed;
		this.fuel = fuel;
		this.power = power;
		this.consumption = consumption;
	}

	public int getDisplacement() 
	{
		return displacement;
	}

	public String getLicensePlate() 
	{
		return licensePlate;
	}

	public int getMaxSpeed() 
	{
		return maxSpeed;
	}

	public double getFuel()
	{
		return this.fuel;
	}
	
	public void setFuel(double v)
	{
		this.fuel = v;
		if(this.fuel < 0)
		{
			this.fuel = 0;
		}
	}
	
	public void travel(int km)
	{
		for(int i = 0; i < km; i++)
		{
			this.setFuel(this.getFuel() - this.getConsumption() / 100);
		}
	}
	
	public int getPower()
	{
		return this.power;
	}
	
	public double getConsumption()
	{
		return this.consumption;
	}

	@Override
	public String toString() {
		return super.toString() + ", [displacement=" + displacement + ", power=" + power + ", consumption=" + consumption
				+ ", licensePlate=" + licensePlate + ", maxSpeed=" + maxSpeed + ", fuel=" + fuel + "]";
	}
	
	
	
}
