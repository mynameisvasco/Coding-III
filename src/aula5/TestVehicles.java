package aula5;

public class TestVehicles 
{
	public static void main(String args[])
	{
		Bike b1 = new Bike(2010, "Black", 2);
		System.out.println(b1);
		
		Car c1 = new Car(1992, "White", 4, 220, "21-DB-12", 210, 45, 210, 7);
		System.out.println(c1);
		
		Police policeCar = new Police(2012, "White", 4, 240, "21-DB-12", 250, 90, 250, 9, Police.TYPE.GNR);
		System.out.println(policeCar);
		
		System.out.println(b1.compareTo(policeCar));
		
		//Travel 600km with the police car
		policeCar.travel(600);
		
		System.out.println("Police Car traveled 600km ");
		System.out.println("Current fuel -> " + (int) policeCar.getFuel() + "L");
		System.out.println("Fuel used -> " + (int) Math.floor(policeCar.getConsumption() * 6) + "L\n");
	
		Vehicle[] veh = new Vehicle[3];
		veh[0] = b1;
		veh[1] = c1;
		veh[2] = policeCar;
		
		UtilCompare.sortArray(veh);

		System.out.println("Lista de veículos organizados por ano\n");
		for(Vehicle v : veh)
		{
			System.out.println(v.toString());
		}
	}
}
