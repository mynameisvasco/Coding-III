package aula3;

public class TestFigure 
{
	public static void main(String[] args)
	{
		Circle c1 = new Circle (2);
		Circle c2 = new Circle (1,3,2);
		Circle c3 = new Circle (c1);
		
		System.out.println(c1 + " tem area: " + c1.getArea()
		 + " e perimetro: " + c1.getPerimeter());
		 System.out.println(c3 + " tem area: " + c3.getArea()
		+ " e perimetro: " + c3. getPerimeter());
		 System.out.println("c1 equals to c3? -> " + c1.equals(c3));
		 
		 
		 Square q1 = new Square(2);
		 Square q2 = new Square(3,4,2);
		 Square q3 = new Square(q2);
		 
		 System.out.println(q1 + " tem area: " + q1.getArea()
		 + " e perimetro: " + q1.getPerimeter());
		 System.out.println(q3 + " tem area: " + q3.getArea()
		 + " e perimetro: " + q3.getPerimeter());
		 System.out.println("q1 equals to q3? -> " + q1.equals(q3));
		 
		 
		 Rectangle r1 = new Rectangle(2,3);
		 Rectangle r2 = new Rectangle(3,4,2,3);
		 Rectangle r3 = new Rectangle(r2);
		 
		 System.out.println(r1 + " tem area: " + r1.getArea()
		 + " e perimetro: " + r1.getPerimeter());
		 
		 System.out.println(r3 + " tem area: " + r3.getArea()
		 + " e perimetro: " + r3.getPerimeter());
		 System.out.println("r2 equals to r3? -> " + r2.equals(r3));
	}
}
