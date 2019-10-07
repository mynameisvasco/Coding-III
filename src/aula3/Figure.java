package aula3;

import java.util.LinkedList;

public class Figure 
{
	private LinkedList<Point> points;
	
	public Figure(Point p1, Point p2)
	{
		this.points = new LinkedList<Point>();
		this.points.add(p1);
		this.points.add(p2);
	}	
	
	public double getArea() 
	{
		double area = (this.points.get(1).getX() - this.points.get(0).getX()) * (this.points.get(1).getY() - this.points.get(0).getY());
		return Math.abs(area);
	}

	public double getPerimeter() 
	{
		double p = 2 * (this.points.get(1).getX() - this.points.get(0).getX()) + 2 * this.points.get(1).getY() - this.points.get(0).getY();
		return Math.abs(p);
	}
	
	public LinkedList<Point> getPoints()
	{
		return this.points;
	}
	
	public boolean equals(Figure f)
	{
		if(this.getClass() != f.getClass()) return false;
		
		if(this == f) return true;
		
		for(int i = 0; i < this.points.size(); i++)
		{
			if(!this.points.get(i).equals(f.getPoints().get(i)))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public String toString()
	{
		return this.getClass().getName();
	}
}
