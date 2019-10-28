package aula6;

import java.util.LinkedList;

public class Dish implements Comparable<Dish>
{
	private String name;
	private LinkedList<Dishable> content;
	
	public Dish(String name)
	{
		this.name = name;
		this.content = new LinkedList<Dishable>();
	}
	
	@Override
	public String toString() 
	{
		return "Dish [name=" + name + ", content=" + content + "]";
	}

	public String getName() 
	{
		return name;
	}
	
	public LinkedList<Dishable> getContent() 
	{
		return content;
	}
	
	public boolean addContent(Dishable d)
	{
		return content.add(d);
	}

	public double getKcal()
	{
		double kcal = 0; 
		
		for(Dishable d : content)
		{
			kcal += d.getKcal();
		}
		
		return kcal;
	}
	
	public double getProtein()
	{
		double protein = 0;
		
		for(Dishable d : content)
		{
			protein += d.getProtein();
		}
		
		return protein;
	}
	
	public double getWeight()
	{
		double weight = 0;

		for(Dishable d : content)
		{
			weight += d.getKcal();
		}
		
		return weight;
	}
	
	@Override
	public int compareTo(Dish o) 
	{
		if(this.getKcal() == o.getKcal()) return 0;
		else if(this.getKcal() > o.getKcal()) return 1;
		else return 0;
	}	
}
