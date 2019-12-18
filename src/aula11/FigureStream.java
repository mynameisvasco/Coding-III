package aula11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import aula5.Circle;
import aula5.Figure;
import aula5.Rectangle;
import aula5.Square;

public class FigureStream 
{
	public static void main(String[] args)
	{
		List<Figure> figures = new ArrayList<Figure>();
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(1, 3, 2);
		Square q1 = new Square(2);
		Square q2 = new Square(3, 4, 2);
		Rectangle r1 = new Rectangle(2, 3);
		Rectangle r2 = new Rectangle(3, 4, 2, 3);
		
		figures.add(c1);
		figures.add(c2);
		figures.add(q1);
		figures.add(q2);
		figures.add(r1);
		figures.add(r2);
		
		System.out.println("> Bigger figure is < \n" + biggestFigure(figures));
		System.out.println("> Total area < \n" + totalArea(figures) + "\n");
		System.out.println("> Squares total area < \n" + totalArea(figures, "Square") + "\n");
	}
	
	private static Figure biggestFigure(List<Figure> list)
	{
		return list.stream().sorted((f1, f2) -> f1.compareTo(f2)).collect(Collectors.toList()).get(list.size() - 1);
	}
	
	private static double totalArea(List<Figure> list)
	{
		return list.stream().mapToDouble(Figure::getArea).sum();
	}
	
	private static double totalArea(List<Figure> list, String type)
	{
		return list.stream().filter((k) -> k.getClass().getSimpleName().equals(type)).mapToDouble(Figure::getArea).sum();
	}
}
