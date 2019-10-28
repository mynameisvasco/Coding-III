package aula6;

public class Fish implements Dishable
{
	enum TYPE {FREEZED, NATURAL};
	
	private double protein;
	private double kcal;
	private double weight;
	private TYPE type;
	
	public Fish(double protein, double kcal, double weight, TYPE type)
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
		return "Fish [protein=" + protein + ", kcal=" + kcal + ", weight=" + weight + ", type=" + type + "]";
	}
	
	public boolean equals(Fish f)
	{
		if(this.type == f.getType())
		{
			if(this.protein == f.getProtein())
			{
				if(this.kcal == f.getKcal())
				{
					if(this.weight == f.getWeight())
					{
						return true;
					}
				}
			}
		}
		return false;
	}

}
