package aula9.IceCreamShop;

public class Topping extends IceCreamDecorator
{
	private String topping;
	
	public Topping(IceCream c, String topping) 
	{
		super(c);
		this.topping = topping;
	}
	
	@Override
	public void base(int i)
	{
		super.base(i);
		System.out.print(this.toString());
	}
	
	public String toString()
	{
		return " com " + this.topping;
	}

}
