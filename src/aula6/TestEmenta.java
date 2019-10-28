package aula6;

public class TestEmenta 
{
	public static void main(String[] args) 
	{
		Menu ementa = new Menu("Especial Caloiro", "Snack da UA"); 
		Dish[] pratos = new Dish[10];
		
		for (int i=0; i < pratos.length; i++)
		{ 
			pratos[i] = randPrato(i); 
			int cnt=0;
		
			while (cnt <2) // Adicionar 2 Ingredientes a cada Prato 
			{
				Dishable aux = randAlimento();
				if (pratos[i].addContent(aux))
				{
					cnt++; 
				}
				else
				{
					System.out.println("ERRO: Não é possivel adicionar '" + aux + "' ao -> " + pratos[i]);
				}
			}
			
			ementa.addDish(pratos[i], DAYS_OF_WEEK.rand());
			System.out.println("\n" + ementa); 
		}
	}
	// Retorna um Alimento Aleatoriamente 
	public static Dishable randAlimento() 
	{
		// Dia Aleatório
		switch ((int) (Math.random() * 4)) 
		{ 
			default:
			case 0:
				return new Meat(300, 22.3, 345.3, Meat.TYPE.CHICKEN);
			case 1:
				return new Fish(200, 31.3, 25.3, Fish.TYPE.FREEZED);
			case 2:
				return new Vegetable("Couve Flor", 21.3, 22.4, 150);
			case 3:
				return new Cereal("Milho", 19.3, 32.4, 110);
		}
	}
	
	public static Dish randPrato(int i)
	{
		// Retorna um Tipo de Prato Aleatoriamente 
		switch ((int) (Math.random() * 3))
		{ 
			default:
			case 0:
				return new Dish("Prato N." + i);
			case 1:
				return new VegetarianDish("Prato N." + i + " (Vegetariano)");
			case 2:
				return new DietDish("Prato N." + i + " (Dieta)", 90.8);
		} 
	}
	
}
