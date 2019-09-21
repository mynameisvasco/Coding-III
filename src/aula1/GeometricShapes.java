package aula1;

import java.util.Scanner;

public class GeometricShapes 
{
	static Scanner userInput;
	
	public static void main(String[] args)
	{
		userInput = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("> Geometric Shapes <");
			int shapeSelection;
			do
			{
				System.out.println("[1] - Circle");
				System.out.println("[2] - Rectangle");
				System.out.println("[3] - Triangle");
				System.out.println("[4] - Exit");
				shapeSelection = Integer.parseInt(userInput.nextLine());
			}
			while(shapeSelection <= 0 || shapeSelection > 3);
			
			switch(shapeSelection)
			{
				case 1:
					circlePrompt();
					break;
				
				case 2:
					rectanglePrompt();
					break;
				
				case 3:
					trianglePrompt();
					break;
					
				case 4:
					System.exit(0);
					break;
			}
		}
	}
	
	public static void circlePrompt()
	{
		System.out.println("Center");
		System.out.print("	X -> ");
		double x = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y = Double.parseDouble(userInput.nextLine());
		
		System.out.println("Radius -> ");
		double r = Double.parseDouble(userInput.nextLine());
		
		Circle c = new Circle(new Point(x,y), r);
		
		System.out.println("> Circle information <");
		System.out.println(c.toString());
		
		System.out.println("PRESS [ENTER] TO BACK TO MENU");
		userInput.nextLine();
		
	}
	
	public static void rectanglePrompt()
	{
		System.out.println("Point 1");
		System.out.print("	X -> ");
		double x1 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y1 = Double.parseDouble(userInput.nextLine());

		System.out.println("Point 2");
		System.out.print("	X -> ");
		double x2 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y2 = Double.parseDouble(userInput.nextLine());
		
		System.out.println("Point 3");
		System.out.print("	X -> ");
		double x3 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y3 = Double.parseDouble(userInput.nextLine());
		
		System.out.println("Point 4");
		System.out.print("	X -> ");
		double x4 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y4 = Double.parseDouble(userInput.nextLine());
		
		Rectangle r = new Rectangle(new Point(x1,y1), new Point(x2,y2), new Point(x3,y3), new Point(x4,y4));
	
		System.out.println("> Rectangle information <");
		System.out.println(r.toString());
		
		System.out.println("PRESS [ENTER] TO BACK TO MENU");
		userInput.nextLine();
		
	}
	
	public static void trianglePrompt()
	{
		System.out.println("Point 1");
		System.out.print("	X -> ");
		double x1 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y1 = Double.parseDouble(userInput.nextLine());

		System.out.println("Point 2");
		System.out.print("	X -> ");
		double x2 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y2 = Double.parseDouble(userInput.nextLine());
		
		System.out.println("Point 3");
		System.out.print("	X -> ");
		double x3 = Double.parseDouble(userInput.nextLine());
		System.out.print("	Y -> ");
		double y3 = Double.parseDouble(userInput.nextLine());
		
		
		Triangle r = new Triangle(new Point(x1,y1), new Point(x2,y2), new Point(x3,y3));
		
		System.out.println("> Triangle information <");
		System.out.println(r.toString());
		
		System.out.println("PRESS [ENTER] TO BACK TO MENU");
		userInput.nextLine();
		
	}
}
