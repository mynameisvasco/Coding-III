package ap2019;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Banco 
{
	private String nome;
	private SortedSet<Conta> contas;
	
	public Banco(String nome) 
	{
		super();
		this.nome = nome;
		this.contas = new TreeSet<Conta>();
	}

	public String getNome() 
	{
		return nome;
	}

	public Set<Conta> getContas() 
	{
		return contas;
	}
	
	public boolean add(Conta c)
	{
		return this.contas.add(c);
	}
	
	public Iterator<Conta> iterator()
	{
		return this.contas.iterator();
	}
}
