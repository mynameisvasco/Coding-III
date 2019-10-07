package aula3;

public class Vehicle 
{
	private int displacement;
	private int power;
	private int capacity;
	private String licenseCategory;
	private double weight;
	
	public Vehicle(int displacement, int power, int capacity, String licenseCategory, double weight)
	{
		this.displacement = displacement;
		this.power = power;
		this.capacity = capacity;
		assert (licenseCategory.equals("A") || licenseCategory.equals("B") || licenseCategory.equals("C") || licenseCategory.equals("D")) : "Invalid license category";
		this.licenseCategory = licenseCategory;
		this.weight = weight;
	}
	
	public int getDisplacement()
	{
		return this.displacement;
	}
	
	public int getPower()
	{
		return this.power;
	}
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public String getLicenseCategory()
	{
		return this.licenseCategory;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	public boolean equals(Vehicle v)
	{
		if(v.getClass() != this.getClass()) return false;
		
		if(v.getDisplacement() == this.displacement)
		{
			if(v.getPower() == this.power)
			{
				if(v.getLicenseCategory() == this.licenseCategory)
				{
					if(v.getWeight() == this.weight)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
