package aula9.IceCreamShop;

public class SimpleIceCream implements IceCream
{
	private String type;
	private int base;
	
	public SimpleIceCream(String type)
	{
		this.type = type;
	}
	
	@Override
	public void base(int i) 
	{
		this.base = i;
		System.out.print("\n" + this.toString());
	}

	public String toString()
	{
		return this.base + " bolas de gelado de " + this.type;
	}
}
