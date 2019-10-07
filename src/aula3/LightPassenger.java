package aula3;

public class LightPassenger extends Vehicle
{
	public LightPassenger(int displacement, int power, int capacity, double weight)
	{
		super(displacement, power, capacity, "B", weight);
	}
	
	public String toString()
	{
		return "Veículo: Ligeiro de Passageiros \n"
				+ "Cilindrada: " + this.getDisplacement() + "\n"
				+ "Potência: " + this.getPower() + "\n"
				+ "Capacidade: " + this.getCapacity() + "\n"
				+ "Peso: " + this.getWeight() + "\n";
	}
}
