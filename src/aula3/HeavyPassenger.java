package aula3;

public class HeavyPassenger extends Vehicle
{
	public HeavyPassenger(int displacement, int power, int capacity, double weight)
	{
		super(displacement, power, capacity, "C", weight);
	}
	
	public String toString()
	{
		return "Veículo: Pesado de Passageiros \n"
				+ "Cilindrada: " + this.getDisplacement() + "\n"
				+ "Potência: " + this.getPower() + "\n"
				+ "Capacidade: " + this.getCapacity() + "\n"
				+ "Peso: " + this.getWeight() + "\n";
	}
}
