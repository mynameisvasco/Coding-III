package aula3;

public class HeavyGoods extends Vehicle
{
	public HeavyGoods(int displacement, int power, int capacity, double weight)
	{
		super(displacement, power, capacity, "D", weight);
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
