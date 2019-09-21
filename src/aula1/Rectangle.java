package aula1;

public class Rectangle 
{
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	
	public Rectangle(Point p1, Point p2, Point p3, Point p4)
	{
		assert isRectangle(p1,p2,p3,p4) : "Points provided don't form a rectangle";
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	public String getPoints()
	{
		return "{" + this.p1.toString() + "," + this.p2.toString() + "," + this.p3.toString() + "," + this.p4.toString() + "}";
	}

	
	public double getArea()
	{
	
		return Point.distanceBetween(p1, p2) * Point.distanceBetween(p2, p3);
	}
	
	public double getPerimeter()
	{
		return Point.distanceBetween(p1, p2) + Point.distanceBetween(p2, p3) + Point.distanceBetween(p3, p4) + Point.distanceBetween(p4, p1);
	}
	
	public String toString()
	{
		return "Points: [" + this.getPoints() + "]" + "\n Area: " + this.getArea() + "\n Perimeter: " + this.getPerimeter();
	}
	
	public static boolean isRectangle(Point p1, Point p2, Point p3, Point p4)
	{
		double cx = (p1.getX() + p2.getX() + p3.getX() + p4.getX()) / 4;
		double cy = (p1.getY() + p2.getY() + p3.getY() + p4.getY()) / 4;
		
		
		double dd1 = Math.pow((cx - p1.getX()), 2) + Math.pow((cy - p1.getY()), 2);
		double dd2 = Math.pow((cx - p2.getX()), 2) + Math.pow((cy - p2.getY()), 2);
		double dd3 = Math.pow((cx - p3.getX()), 2) + Math.pow((cy - p3.getY()), 2);
		double dd4 = Math.pow((cx - p4.getX()), 2) + Math.pow((cy - p4.getY()), 2);
		
		return dd1 == dd2 && dd1 == dd3 && dd1 ==dd4;
	}
}
