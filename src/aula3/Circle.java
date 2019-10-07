package aula3;

public class Circle extends Figure
{
	private double radius;
	
	public Circle(double r)
	{
		this(0, 0, r);
	}
	
	public Circle(Circle c)
	{
		this(c.getPoints().get(0).getX(), c.getPoints().get(0).getY(), c.getRadius());
	}
	
	public Circle(double x, double y, double r)
	{
		super(new Point(x, y), new Point(x, y + r));
		this.radius = r;
	}
	
	
	@Override
	public double getArea()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * Math.PI * this.radius;
	}
	
	public double getRadius()
	{
		return this.radius;
	}

}
