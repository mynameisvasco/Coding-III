package ap2019;

public class eConta extends Conta implements Eletronica
{	
	public eConta(Cliente c) 
	{
		super(c);
		if(c.getClientType() != TipoCliente.Online)
		{
			throw new RuntimeException("Uma eConta s� pode pertencer a um cliente online");
		}
	}
}
