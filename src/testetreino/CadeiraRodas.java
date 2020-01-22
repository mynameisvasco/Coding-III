package testetreino;

public class CadeiraRodas extends Cadeira implements Transporte
{
	private int numeroRodas;
	private boolean eletrica;
	private TipoTransporte tipoTransporte;
	public CadeiraRodas(String designacao, int id, Mobiliario.Tipo material, Mobiliario.TipoCadeira tipo, double altura, int numeroApoios, 
			int numeroRodas, boolean eletrica) 
	{
		super(designacao, id, material, tipo, altura, numeroApoios);
		this.numeroRodas = numeroRodas;
		this.eletrica = eletrica;
	}
	
	public int getNumeroRodas() 
	{
		return numeroRodas;
	}
	
	public boolean isEletrica() 
	{
		return eletrica;
	}

	public TipoTransporte getTipoTransporte() 
	{
		return this.tipoTransporte;
	}

	public void setTipo(TipoTransporte tipo) 
	{
		this.tipoTransporte = tipo;
	}
}
