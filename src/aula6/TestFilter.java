package aula6;
import java.util.List;
import java.util.ArrayList;
import aula3.Fellow;
import aula5.Figure;
import aula5.Circle;
import aula5.Square;
import aula5.Rectangle;
import aula3.Student;
import aula1.Date;

public class TestFilter 
{
	public static void main(String[] args) 
	{
		List<Figure> lista = new ArrayList<Figure>();
		lista.add(new Circle(2)); lista.add(new Circle(1, 3, 1));
		lista.add(new Square(5)); lista.add(new Square(3, 4, 2));
		lista.add(new Rectangle(2, 3)); lista.add(new Rectangle(3, 4, 5, 3));
		lista.add(new Rectangle(1, 1, 5, 6));
		
		System.out.println("Figures Filter 1:");
		List<Figure> ret = ListProcess.filter(lista, f -> f.getArea() > 20);
		printList(ret);
		
		System.out.println("\nFigures Filter 2:");
		ret = ListProcess.filter(lista, f -> f.getPerimeter() < 15);
		printList(ret);
		
		System.out.println("\nFigures Filter 3:");
		ret = ListProcess.filter(lista, f -> f.getPerimeter() < 15 && f.getArea() > 10);
		printList(ret);
		
		List<Student> lista2 = new ArrayList<Student>();
		lista2.add(new Student("Andreia", 9855678, new Date(18, 7, 1974)));
		lista2.add(new Student("Monica", 75266454, new Date(11, 8, 1978)));
		lista2.add(new Student("Jose", 85265426, new Date(15, 2, 1976)));
		lista2.add(new Fellow("Maria", 8976543, new Date(12, 5, 1976)));
		lista2.add(new Fellow("Xico", 872356522, new Date(21, 4, 1975)));
		
		System.out.println("\nStudent Filter 1:");
		List<Student> ret2 = ListProcess.filter(lista2, e -> e.getNmec() < 103);
		printList(ret2);
		
		System.out.println("\nStudent Filter 2:");
		ret2 = ListProcess.filter(lista2,
		e -> e.getClass().getSimpleName().equals("Bolseiro"));
		printList(ret2);
	}
	
	private static <T> void printList(List<T> myList) 
	{
		for (T e : myList)
			System.out.println(e);
	}
}