package aula3;

import java.util.LinkedList;

import aula1.Date;

public class DrivingLicense 
{
	public static int BASE_NUMBER = 99;
	private int number;
	private LinkedList<String> category; //Driver can have more than 1 category in  1 driving license
	private Date expireDate;
	
	public DrivingLicense(String[] category, Date expireDate)
	{
		this.number = BASE_NUMBER++;
		assert (category.equals("A") || category.equals("B") || category.equals("C") || category.equals("D")) : "Invalid license category";
		this.category = new LinkedList<String>();
		for(String s : category)
		{
			this.category.add(s);
		}
		this.expireDate = expireDate;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public LinkedList<String> getCategory()
	{
		return this.category;
	}
	
	public String getCategoryString()
	{
		String s = "[";
		
		for(int i = 0; i < this.category.size(); i++)
		{
			s += this.category.get(i) + ", ";
		}
		
		s += "]";
		
		return s;
	}
	
	public Date getExpireDate()
	{
		return this.expireDate;
	}
	
	public void setExpireDate(Date d)
	{
		this.expireDate = d;
	}
	
	public void addCategory(String[] s)
	{
		for(String ss : s)
		{
			this.category.add(ss);
		}
	}
	
	public void addCategory(String s)
	{
		this.category.add(s);
	}
	
	public String toString()
	{
		return "Number: " + this.number + "\n"
				+ "Categories: " + this.getCategoryString() + "\n";
	}
}
