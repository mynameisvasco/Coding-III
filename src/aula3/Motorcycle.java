package aula3;

public class Motorcycle extends Vehicle
{
	public Motorcycle(int displacement, int power, int capacity, double weight)
	{
		super(displacement, power, capacity, "A", weight);
	}
	
	public String toString()
	{
		return "Veículo: Motociclo\n"
				+ "Cilindrada: " + this.getDisplacement() + "\n"
				+ "Potência: " + this.getPower() + "\n"
				+ "Capacidade: " + this.getCapacity() + "\n"
				+ "Peso: " + this.getWeight() + "\n";
	}
}
