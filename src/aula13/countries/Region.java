package aula13.countries;

public class Region 
{
	private String name;
	private int population;
	
	public Region(String name, int population)
	{
		this.name = name;
		this.population = population;
	}

	public int getPopulation() 
	{
		return population;
	}

	public void setPopulation(int population) 
	{
		this.population = population;
	}

	public String getName() 
	{
		return name;
	}
	
	public String toString()
	{
		return this.getName() + " population: " + this.getPopulation();
	}
}
