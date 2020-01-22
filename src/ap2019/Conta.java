package ap2019;

import java.util.ArrayList;
import java.util.List;

public class Conta implements Comparable<Conta>
{
	public static int contaNum = 0;
	private int numero;
	private Cliente cliente;
	private double saldo;
	private List<Movimento> movimentos;
	
	public Conta(Cliente c)
	{
		this.numero = Conta.contaNum;
		this.cliente = c;
		this.saldo = 0;
		this.movimentos = new ArrayList<Movimento>();
		Conta.contaNum += 1;
	}

	public int getNumero() 
	{
		return numero;
	}

	public Cliente getCliente() 
	{
		return cliente;
	}

	public double getSaldo() 
	{
		return saldo;
	}

	public List<Movimento> getMovimentos() 
	{
		return movimentos;
	}
	
	public boolean add(Movimento m)
	{
		if(m.getClass().getSimpleName().equals("Debito"))
		{
			this.saldo -= m.getMontante();
		}
		else
		{
			this.saldo += m.getMontante();
		}
		
		return this.movimentos.add(m);
	}
	
	public String toString() 
	{
		return "N: " + numero + ", Cliente: " + cliente + ", Saldo: " + saldo + ", Movimentos: " + movimentos + "[" + this.cliente.getClientType().toString() +"]"; 
	}
	
	public int compareTo(Conta c)
	{
		if(c.getNumero() == this.getNumero()) return 0;
		else if(c.getNumero() > this.getNumero()) return -1;
		else return 1;
	}
}
