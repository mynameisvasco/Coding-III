package aula6;

public class Cereal implements VegDishable
{
	private String name;
	private double protein;
	private double kcal;
	private double weight;
	
	public Cereal(String name, double protein, double kcal, double weight) 
	{
		super();
		this.protein = protein;
		this.kcal = kcal;
		this.weight = weight;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public double getProtein() 
	{
		return protein;
	}
	
	public double getKcal() 
	{
		return kcal;
	}
	
	public double getWeight() 
	{
		return weight;
	}	
	
	@Override
	public String toString() 
	{
		return "Cereal [protein=" + protein + ", kcal=" + kcal + ", weight=" + weight + ", name=" + name + "]";
	}
	
	public boolean equals(VegDishable m)
	{
		if(this.name.equals(m.getName()))
		{
			if(this.protein == m.getProtein())
			{
				if(this.kcal == m.getKcal())
				{
					if(this.weight == m.getWeight())
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
