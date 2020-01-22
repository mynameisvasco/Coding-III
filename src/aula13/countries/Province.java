package aula13.countries;

public class Province extends Region
{
	private String governator;
	
	public Province(String name, int population, String governator) 
	{
		super(name, population);
		this.governator = governator;
	}

	public String getGovernator() 
	{
		return governator;
	}
	
	public void setGovernator(String capital) 
	{
		this.governator = capital;
	}
}
