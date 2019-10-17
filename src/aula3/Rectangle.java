package aula3;

public class Rectangle extends Figure
{
	public Rectangle(double x1, double y1, double side1, double side2)
	{
		super(new Point(x1,y1), side1, side2);
	}
	
	public Rectangle(double side1, double side2)
	{
		super(new Point(0, 0), side1, side2);
	}
	
	public Rectangle(Rectangle r)
	{
		super(r.getCenter(), r.getSides()[0], r.getSides()[1]);
	}
}
