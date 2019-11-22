package aula9.IceCreamShop;

public class IceCreamDecorator implements IceCream
{
	private IceCream ice;

	public IceCreamDecorator(IceCream ice) 
	{
		this.ice = ice;
	}

	public void base(int i) 
	{
		ice.base(i);
	}
	
	public String toString()
	{
		return ice.toString();
	}
}
