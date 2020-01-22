package aula13.countries;

public class State extends Region
{
	private Locality capital;
	
	public State(String name, int population, Locality capital)
	{
		super(name, population);
		this.capital = capital;
	}
	
	public Locality getCapital() 
	{
		return capital;
	}
	
	public void setCapital(Locality capital) 
	{
		this.capital = capital;
	}

}
