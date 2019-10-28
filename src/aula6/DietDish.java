package aula6;

public class DietDish extends Dish implements Comparable<Dish>
{
	private double maxKcal;
	
	public DietDish(String name, double maxKcal)
	{		
		super(name);
		this.maxKcal = maxKcal;
	}
	
	@Override
	public String toString() 
	{
		return "DietDish [name=" + this.getName() + ", content=" + this.getContent() + "]";
	}
	
	public double getMaxKcal()
	{
		return maxKcal;
	}
}
