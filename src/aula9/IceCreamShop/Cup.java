package aula9.IceCreamShop;

public class Cup extends IceCreamDecorator
{
	public Cup(IceCream ice) 
	{
		super(ice);
	}
	
	@Override
	public void base(int i)
	{
		super.base(i);
		System.out.print(this.toString());
	}
	
	public String toString()
	{
		return " em copo ";
	}
}
