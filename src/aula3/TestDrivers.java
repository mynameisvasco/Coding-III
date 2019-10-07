package aula3;

import aula1.Date;

public class TestDrivers 
{
	public static void main(String[] args)
	{
		Driver d = new Driver("Vasco", 912112, new Date("27/01/2000"), new String[] {"A", "B"}, new Date("12/12/2037"));
		Driver d2 = new Driver("José", 21112, new Date("21/03/1992"), new String[] {"A", "B", "C", "D"}, new Date("11/04/2031"));

		System.out.println(d);
		System.out.println(d2);
		
		HeavyGoods truck1 = new HeavyGoods(1000, 1000, 5, 5300);
		
		System.out.println(truck1);
		
		if(d.canDrive(truck1))
		{
			System.out.println(d.getName() + " pode conduzir o seguinte veículo");
			System.out.println(truck1.toString());
		}
		else
		{
			System.out.println(d.getName() + " não pode conduzir o seguinte veículo");
			System.out.println(truck1.toString());
		}
		
		if(d2.canDrive(truck1))
		{
			System.out.println(d2.getName() + " pode conduzir o seguinte veículo");
			System.out.println(truck1.toString());
		}
		else
		{
			System.out.println(d2.getName() + " não pode conduzir o seguinte veículo");
			System.out.println(truck1.toString());
		}
	}
}
