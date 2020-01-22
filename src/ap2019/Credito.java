package ap2019;

public class Credito extends Movimento
{

	public Credito(double montante, String data) 
	{
		super(montante, data);
		// TODO Auto-generated constructor stub
	}

	public String toString() 
	{
		return "Credito > ["+ this.getMontante() + "," + this.getData() + "]";
	}
}
