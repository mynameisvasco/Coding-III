package testetreino;

public class Cadeira extends Mobiliario
{
	private Mobiliario.TipoCadeira tipo;
	private int numeroApoios;
	private double altura;
	
	public Cadeira(String designacao, int id, Mobiliario.Tipo material, Mobiliario.TipoCadeira tipo, double altura, int numeroApoios) 
	{
		super(designacao, id, material);
		this.tipo =  tipo;
		this.numeroApoios = numeroApoios;
		this.altura = altura;
	}

	public Mobiliario.TipoCadeira getTipo() 
	{
		return tipo;
	}

	public int getNumeroApoios() 
	{
		return numeroApoios;
	}

	public double getAltura() 
	{
		return altura;
	}	
	
	
}
