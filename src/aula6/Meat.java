package aula6;

public class Meat implements Dishable
{
	enum TYPE {COW, PIG, PERU, CHICKEN, OTHER};
	
	private double protein;
	private double kcal;
	private double weight;
	private TYPE type;
	
	public Meat(double protein, double kcal, double weight, TYPE type) 
	{
		super();
		this.protein = protein;
		this.kcal = kcal;
		this.weight = weight;
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
	
	public TYPE getType()
	{
		return this.type;
	}
	
	
	@Override
	public String toString() 
	{
		return "Meat [protein=" + protein + ", kcal=" + kcal + ", weight=" + weight + ", type=" + type + "]";
	}
	
	public boolean equals(Meat m)
	{
		if(this.type == m.getType())
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
