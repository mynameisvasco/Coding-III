package testetreino;

public class Maca extends Marquesa implements Transporte
{
	private int numeroGrades;
	private TipoTransporte tipoTransporte;
	
	public Maca(String designacao, int id, Mobiliario.Tipo material, double altura, double largura, boolean colchao,
			int numeroGrades) 
	{
		super(designacao, id, material, altura, largura, colchao, false);
		this.numeroGrades = numeroGrades;
	}

	public int getNumeroGrades() 
	{
		return numeroGrades;
	}

	public TipoTransporte getTipoTransporte() {
		return this.tipoTransporte;
	}

	public void setTipo(TipoTransporte tipo) {
		this.tipoTransporte = tipo;
		
	}
}
