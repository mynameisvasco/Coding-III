package testetreino;

import java.io.Serializable;

public class Mobiliario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6033241895353682472L;
	private String designacao;
	private int id;
	private Tipo material;
	
	public Mobiliario(String designacao, int id, Tipo material) 
	{
		super();
		this.designacao = designacao;
		this.id = id;
		this.material = material;
	}
	
	public String getDesignacao() 
	{
		return designacao;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public Tipo getMaterial() 
	{
		return material;
	}
	
	public enum Tipo 
	{
		Madeira,
		Plastico,
		Metal,
		Sintetico,
	}

	public enum TipoCadeira
	{
		Escritorio,
		Espera,
		Atendimento
	}
	
	public enum TipoCama
	{
		Manual,
		Eletrica
	}
	
}
