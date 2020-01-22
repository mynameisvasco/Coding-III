package testetreino;

public class Marquesa extends Cama
{
	private boolean inclinacao;

	public Marquesa(String designacao, int id, Mobiliario.Tipo material, double altura, double largura, boolean colchao,
			boolean inclinacao) 
	{
		super(designacao, id, material, altura, largura, colchao);
		this.inclinacao = inclinacao;
	}

	public boolean isInclinacao() 
	{
		return inclinacao;
	}
}

