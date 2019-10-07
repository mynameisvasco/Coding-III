package aula3;

public class Square extends Figure
{
	public Square(double x)
	{
		super(new Point(0, 0), new Point(x, x));
	}
	
	public Square(double x1, double y1, double side)
	{
		super(new Point(x1, y1), new Point(x1 + side, y1 + side));
	}
	
	public Square(Square s)
	{
		super(s.getPoints().get(0), s.getPoints().get(1));
	}
}
