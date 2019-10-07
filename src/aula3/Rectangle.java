package aula3;

public class Rectangle extends Figure
{
	public Rectangle(double x1, double y1, double x2, double y2)
	{
		super(new Point(x1,y1), new Point(x2, y2));
	}
	
	public Rectangle(double x1, double y1)
	{
		super(new Point(0, 0), new Point(x1, y1));
	}
	
	public Rectangle(Rectangle r)
	{
		super(r.getPoints().get(0), r.getPoints().get(1));
	}
}
