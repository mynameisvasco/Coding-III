package aula9.IceCreamShop;

public class TestIceCreamShop 
{
	public static void main(String args[]) 
	{
		IceCream ice;
		ice = new SimpleIceCream("Baunilha");
		ice.base(2);
		new Cup(ice).base(3);
		new Cone(ice).base(1);
		new Topping(ice, "Canela").base(2);
		ice = new Topping(ice, "Nozes");
		ice.base(1);
		ice = new Topping(new Cone(new SimpleIceCream("Morango")), "Fruta");
		ice.base(2);
		ice = new Topping(
		new Topping(
		new Cup(new SimpleIceCream("Manga")), "Chocolate"), "Natas");
		ice.base(4);
		ice = new Topping(ice, "Pepitas");
		ice.base(3);
	}
}
