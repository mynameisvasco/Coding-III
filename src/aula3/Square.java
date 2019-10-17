package aula3;

public class Square extends Figure
{
	public Square(double side)
	{
		super(new Point(0, 0), side, side);
	}
	
	public Square(double x1, double y1, double side)
	{
		super(new Point(x1, y1), side, side);
	}
	
	public Square(Square s)
	{
		super(s.getCenter() , s.getSides()[0], s.getSides()[1]);
	}
}
