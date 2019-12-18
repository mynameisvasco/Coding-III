package aula10;

import java.util.Iterator;
import aula5.Circle;
import aula5.Figure;
import aula5.Rectangle;
import aula5.Square;

public class TestGeneric
{
	public static void main(String[] args)
	{
		ListGeneric<Figure> list = new ListGeneric<Figure>();
		
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(1, 3, 2);
		Square q1 = new Square(2);
		Square q2 = new Square(3, 4, 2);
		Rectangle r1 = new Rectangle(2, 3);
		Rectangle r2 = new Rectangle(3, 4, 2, 3);
		
		list.addElem(c1);
		list.addElem(c2);
		list.addElem(q1);
		list.addElem(q2);
		list.addElem(r1);
		list.addElem(r2);
		
		System.out.println("Area total: " +  sumArea(list));
		printSet(list.iterator());
		

	}
	
	public static double sumArea(ListGeneric<Figure> list)
	{
		double area = 0;
		
		for(Figure f : list)
		{
			area += f.getArea();
		}
		
		return area;
	}
	
	public static void printSet(Iterator set)
	{
		do
		{
			System.out.println(set.next());
		}
		while(set.hasNext());
	}
}
