package aula13.countries;

public class Locality extends Region
{
	private LocalityType type;
	
	public Locality(String name, int population, LocalityType type)
	{
		super(name, population);
		this.type = type;
	}

	public LocalityType getType() 
	{
		return type;
	}

	public void setType(LocalityType type) 
	{
		this.type = type;
	}
}


