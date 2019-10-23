package aula5;

public class Figure implements Comparable<Figure>
{
	private Point center;
	private double side1;
	private double side2;
	
	public Figure(Point center, double side1, double side2)
	{
		this.center = center;
		this.side1 = side1;
		this.side2 = side2;
	}	
	
	public double getArea() 
	{
		double area = this.side1 * this.side2;
		return Math.abs(area);
	}

	public double getPerimeter() 
	{
		double p = 2 * this.side1 + 2 * this.side2;
		return Math.abs(p);
	}
	
	public Point getCenter()
	{
		return this.center;
	}
	
	public double[] getSides()
	{
		return new double[] {this.side1, this.side2};
	}
	
	public boolean equals(Figure f)
	{
		if(this.getClass() != f.getClass()) return false;
		
		if(this == f) return true;
		
		if(this.center.equals(f.getCenter()))
		{
			if(this.side1 == f.getSides()[1] && this.side2 == f.getSides()[2])
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String toString()
	{
		return this.getClass().getSimpleName() + "\n"
				+ "Area: " + this.getArea() + "\n"
				+ "Perimeter: " + this.getPerimeter() + "\n"
				+ "Center: " + this.getCenter() + "\n";
	}
	
	public int compareTo(Figure f)
	{
		if(this.getArea() == f.getArea())
		{
			return 0;
		}
		else if(this.getArea() > f.getArea())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
