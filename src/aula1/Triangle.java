package aula1;

public class Triangle 
{
	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(Point p1, Point p2, Point p3)
	{
		assert isTriangle(p1,p2,p3) : "Points provided don't form a triangle";
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public String getPoints()
	{
		return "{" + this.p1.toString() + "," + this.p2.toString() + "," + this.p3.toString() + "}";
	}

	public double getArea()
	{
		double base = Point.distanceBetween(p1, p2);
		double height = Point.distanceBetween(Point.halfPoint(p1, p2), p3);
		
		return (base*height) / 2;
	}
	
	public double getPerimeter()
	{
		return Point.distanceBetween(p1, p2) + Point.distanceBetween(p2, p3) + Point.distanceBetween(p1, p3);
	}
	
	public String toString()
	{
		return "Points: [" + this.getPoints() + "]" + "\n Area: " + this.getArea() + "\n Perimeter: " + this.getPerimeter();
	}
	
	public static boolean isTriangle(Point p1, Point p2, Point p3) 
	{
		double a = Point.distanceBetween(p1, p2);
		double b = Point.distanceBetween(p2, p3);
		double c = Point.distanceBetween(p3, p1);
		
        if((a + b) > c && (a + c) > b && (b + c) > a) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}

