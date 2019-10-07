package aula3;

public class Point 
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
	
	public boolean equals(Point p)
	{
		if(p.getX() == this.getX() && p.getY() == this.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
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
