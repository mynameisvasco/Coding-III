package aula1;

class Point 
{
	private double x;
	private double y;
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public String toString()
	{
		return "(" + this.x + "," + this.y + ")";
	}
	
	public static double distanceBetween(Point p1, Point p2)
	{
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow(p2.y - p1.y, 2));
	}
	
	public static Point halfPoint(Point p1, Point p2)
	{
		return new Point( (p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}
}

public class Circle 
{
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius)
	{
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(double x, double y, double radius)
	{
		this.center = new Point(x, y);
		this.radius = radius;
	}
	
	public Point getCenter()
	{
		return this.center;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public double getArea()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	public double getPerimeter()
	{
		return 2 * Math.PI * this.radius;
	}
	
	public String toString()
	{
		return "Center: [" + this.getCenter() + "]" + "\n Radius: " + this.getRadius() + "\n Area: " + this.getArea() + "\n Perimeter: " + this.getPerimeter();
	}
	
	public static boolean areEqual(Circle c1, Circle c2)
	{
		return c1.getRadius() == c2.getRadius();
	}
	
	public static boolean doIntersect(Circle c1, Circle c2)
	{
		double distanceX = c1.getCenter().getX() - c2.getCenter().getX();
        double distanceY = c1.getCenter().getY() - c2.getCenter().getY();
        double radiusSum = c1.getRadius() + c2.getRadius();
        return distanceX * distanceX + distanceY * distanceY <= radiusSum * radiusSum;
	}
}
