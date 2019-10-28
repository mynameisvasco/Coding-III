package aula6;

public class VegetarianDish extends Dish implements Comparable<Dish>
{
	public VegetarianDish(String name)
	{
		super(name);
	}	
	
	@Override
	public String toString() 
	{
		return "VegetarianDish [name=" + this.getName() + ", content=" + this.getContent() + "]";
	}

	@Override
	public boolean addContent(Dishable d)
	{
		if(d instanceof VegDishable)
		{
			return super.addContent(d);
		}
		
		return false;
	}
	
	
}
	