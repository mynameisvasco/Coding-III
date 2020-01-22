package ap2019;

public class Movimento 
{
	private double montante;
	private String data;
	
	public Movimento(double montante, String data) 
	{
		super();
		this.montante = montante;
		this.data = data;
	}

	public double getMontante() 
	{
		return montante;
	}

	public String getData() 
	{
		return data;
	}
}
