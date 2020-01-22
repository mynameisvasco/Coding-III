package ap2019;

public class Debito extends Movimento
{
	public Debito(double montante, String data) 
	{
		super(montante, data);
		// TODO Auto-generated constructor stub
	}

	public String toString() 
	{
		return "Debito > ["+ this.getMontante() + "," + this.getData() + "]";
	}
}
