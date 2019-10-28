package aula6;

import java.util.LinkedList;

enum DAYS_OF_WEEK 
{ 
	MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	public static DAYS_OF_WEEK rand()
	{
		int i = (int) (Math.random() * (6 - 0)) + 0;
		return DAYS_OF_WEEK.values()[i];
	}
}

class DayMenu 
{
	private DAYS_OF_WEEK day;
	private LinkedList<Dish> dishes;
	
	public DayMenu(DAYS_OF_WEEK day)
	{
		this.day = day;
		this.dishes = new LinkedList<Dish>();
	}
	
	public boolean addDish(Dish d)
	{
		return this.dishes.add(d);
	}
	
	public LinkedList<Dish> getDishes()
	{
		return this.dishes;
	}
	
	public DAYS_OF_WEEK getDay()
	{
		return this.day;
	}
	
	public String toString()
	{
		String s = "";

		for(Dish d : this.dishes)
		{
			s += this.day + " -> " + d.toString();
		}
	
		return s;
	}
}

public class Menu 
{	
	private String name;
	private String place;
	private LinkedList<DayMenu> daysMenu;
	
	public Menu(String name, String place)
	{
		this.name = name;
		this.place = place;
		this.daysMenu = new LinkedList<DayMenu>(); 
		
		for(DAYS_OF_WEEK d : DAYS_OF_WEEK.values())
		{
			this.daysMenu.add(new DayMenu(d));
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPlace()
	{
		return place;
	}
	
	public boolean addDish(Dish dish, DAYS_OF_WEEK day)
	{
		return this.daysMenu.get(day.ordinal()).addDish(dish);
	}
	
	public boolean removeDish(String name, DAYS_OF_WEEK day)
	{
		DayMenu dayMenu = this.daysMenu.get(day.ordinal());
		
		for(int i = 0; i < dayMenu.getDishes().size(); i++)
		{
			for(Dish d : dayMenu.getDishes())
			{
				if(dayMenu.getDay() == day && d.getName().equals(name))
				{
					return dayMenu.getDishes().remove(d);
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", place=" + place + ", dishes=" + daysMenu + "]";
	}
	

}
