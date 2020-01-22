package testetreino;

public class CamaArticulada extends Cama
{
	private Mobiliario.TipoCama tipo;

	public CamaArticulada(String designacao, int id, Mobiliario.Tipo material, double altura, double largura, boolean colchao,
			boolean eletrica) 
	{
		super(designacao, id, material, altura, largura, colchao);
		if(eletrica)
		{
			this.tipo = Mobiliario.TipoCama.Eletrica;
		}
		else
		{
			this.tipo = Mobiliario.TipoCama.Manual;
		}
	}

	public Mobiliario.TipoCama getTipo() 
	{
		return tipo;
	}
}
