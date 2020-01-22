package aula13.countries;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class Country 
{
	private String name;
	private Locality capital;
	private List<Region> regions;
	
	public Country(String name)
	{
		this.name = name;
		this.regions = new ArrayList<Region>();
	}
	
	public Country(String name, Locality capital)
	{
		if(capital.getType() != LocalityType.CITY)
		{
			throw new IllegalArgumentException("Invalid capital, must be a CITY");
		}
		this.name = name;
		this.capital = capital;
		this.regions = new ArrayList<Region>();
	}

	public Locality getCapital() 
	{
		return capital;
	}

	public void setCapital(Locality capital) 
	{
		this.capital = capital;
	}

	public String getName() 
	{
		return name;
	}

	public List<Region> getRegions() 
	{
		return regions;
	}
	
	public void addRegion(Region region)
	{
		this.regions.add(region);
	}
	
	public int getPopulation()
	{
		int population = 0;
		
		for(Region r : this.regions)
		{
			population += r.getPopulation();
		}
		
		return population;
	}
	
	public String toString()
	{
		return "Country: " + this.getName() +", Populaçao: "+ this.getPopulation() +" (Capital: "+ this.getCapital() +")\n";
	}
}
