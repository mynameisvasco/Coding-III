package ap2019;

public class Cliente 
{
	private String nome;
	private String contribuinte;
	private TipoCliente tipoCliente;
	
	public Cliente(String nome, String contribuinte, TipoCliente tipoCliente)
	{
		this.nome = nome;
		this.contribuinte = contribuinte;
		this.tipoCliente = tipoCliente;
	}
	
	public String getNome() 
	{
		return nome;
	}


	public String getContribuinte() 
	{
		return contribuinte;
	}


	public TipoCliente getClientType() 
	{
		return tipoCliente;
	}
	
	public String toString()
	{
		return this.getNome();
	}
}
