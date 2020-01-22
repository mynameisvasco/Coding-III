package ap2019;

public class Individual extends Cliente
{
	private String telefone;
	
	public Individual(String nome, String contribuinte, TipoCliente tipoCliente)
	{
		super(nome, contribuinte, tipoCliente);
		this.telefone = "0";
	}
	
	public Individual(String nome, String contribuinte, TipoCliente tipoCliente, String telefone) 
	{
		super(nome, contribuinte, tipoCliente);
		this.telefone = telefone;
	}

	public String getTelefone() 
	{
		return telefone;
	}

	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}	
}
