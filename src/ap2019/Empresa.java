package ap2019;

public class Empresa extends Cliente
{
	private Cliente gerente;
	
	public Empresa(String nome, String contribuinte, TipoCliente tipoCliente, Cliente gerente) 
	{
		super(nome, contribuinte, tipoCliente);
		this.gerente = gerente;
	}

	public Cliente getGerente() 
	{
		return gerente;
	}

	public void setGerente(Cliente gerente) 
	{
		this.gerente = gerente;
	}
}
