package testetreino;

public class Cama extends Mobiliario
{
	private double altura;
	private double largura;
	private boolean colchao;
	
	public Cama(String designacao, int id, Mobiliario.Tipo material, double altura, double largura, boolean colchao) 
	{
		super(designacao, id, material);
		this.altura = altura;
		this.largura = largura;
		this.colchao = colchao;
	}

	public double getAltura() 
	{
		return altura;
	}

	public double getLargura() 
	{
		return largura;
	}

	public boolean isColchao() 
	{
		return colchao;
	}
	
	
}
