package aula5;

import java.util.LinkedList;

public class FigureCollection 
{
	private double maxArea;
	private LinkedList<Figure> list;
	
	public FigureCollection(double maxArea)
	{
		this.maxArea = maxArea;
		list = new LinkedList<Figure>();
	}
		
	public boolean addFigure(Figure f)
	{
		if(this.exists(f)) return false;
		
		if(this.getTotalArea() + f.getArea() < this.maxArea)
		{			
			return this.list.add(f);
		}
		else
		{			
			return false;
		}
	}
	
	public boolean delFigure(Figure f)
	{

		for(int i = 0; i < this.list.size(); i++)
		{
			if(this.list.get(i).equals(f))
			{
				this.list.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public double getTotalArea()
	{
		double area = 0;
		
		for(Figure f : list)
		{
			area += f.getArea();
		}
		
		return area;
	}
	
	public boolean exists(Figure f)
	{
		for(Figure ff : list)
		{
			if(f.equals(ff))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public Figure[] getFigures()
	{
		Figure[] a = new Figure[this.list.size()];
		
		for(int i = 0; i < this.list.size(); i++)
		{
			a[i] = this.list.get(i);
		}
		
		return a;
	}
	
	public LinkedList<Point> getCenters()
	{
		LinkedList<Point> points = new LinkedList<Point>();
		
		for(Figure f : this.list)
		{
			points.add(f.getCenter());
		}
		
		return points;
		
	}
	
	public String toString()
	{
		String s = "";
		
		for(Figure f : this.list)
		{
			s += f.toString();
		}
		
		return s;
	}
	
}
