package aula4;

import aula3.Circle;
import aula3.Figure;
import aula3.Square;
import aula3.Rectangle;
import aula3.Point;

public class TestFigureCollection 
{
	public static void main(String[] args)
	{
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(1, 3, 2);
		Square q1 = new Square(2);
		Square q2 = new Square(3, 4, 2);
		Rectangle r1 = new Rectangle(2, 3);
		Rectangle r2 = new Rectangle(3, 4, 2, 3);
		FigureCollection col = new FigureCollection(42.0); // MaxArea
		System.out.println(col.addFigure(c2)); // true
		System.out.println(col.addFigure(r1)); // true
		System.out.println(col.addFigure(r1)); // false
		System.out.println(col.addFigure(r2)); // true
		System.out.println(col.addFigure(c1)); // true
		System.out.println(col.addFigure(q2)); // true
		System.out.println(col.addFigure(q1)); // false
		System.out.println(col.delFigure(r1)); // true
		System.out.println(col.addFigure(q1)); // true
		
		System.out.println("\nÁrea Total da Lista de Figuras: " + col.getTotalArea());
		
		System.out.println("\nLista de Figuras:");
		for (Figure f: col.getFigures())
			System.out.println(f);
		
		System.out.println("\n\nCircles na Lista de Figuras:");
		for (Figure f: col.getFigures())
			if (f instanceof Circle)
				System.out.println(f);
		
		System.out.println("\n\nCentro das Figuras:");
	 	for (Point p: col.getCenters())
	 		System.out.println(p); 
	}
}
