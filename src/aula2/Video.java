package aula2;

import java.util.LinkedList;

public class Video 
{
	private int id;
	private String title;
	private String category;
	private String minimiumAge;
	private int status;
	private int ownerId;
	private LinkedList<Integer> ratings;
	
	public Video(String title, String category, String minimiumAge)
	{
		if(Database.videos.size() != 0)
		{			
			this.id = Database.videos.get(Database.videos.size() - 1).id + 1;
		}
		else
		{
			this.id = 1;
		}
		this.title = title;
		this.category = category;
		this.minimiumAge = minimiumAge;
		this.status = 0;
		this.ownerId = 0;
		this.ratings = new LinkedList<Integer>();
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public String getMinimiumAge()
	{
		return this.minimiumAge;
	}
	
	public Double updateRating(int rating)
	{
		ratings.add(rating);
		
		int tmp = 0;
		
		for(int i = 0; i < ratings.size(); i++)
		{
			tmp += ratings.get(i);
		}
		return Math.round(tmp / ratings.size()) / 10.0;
	}
	
	public Double getRating()
	{
		int tmp = 0;
		
		for(int i = 0; i < ratings.size(); i++)
		{
			tmp += ratings.get(i);
		}
		if(ratings.size() == 0)
		{
			return (double) 0;
		}
		return Math.round(tmp / ratings.size() * 10.0) / 10.0;
	}
	
	public String getStatus()
	{
		switch(this.status)
		{
			case 0:
				return "Available";
			case 1:
				return "In use";
		}
		
		return "";
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public Student getOwner()
	{
		return Database.searchStudent(this.ownerId);
	}
	
	public void setOwner(int nmec)
	{
		this.ownerId = nmec;
	}
	
	public String toString()
	{
		return "----------------------------------\n"
				+ "ID: " + this.id + "\n"
				+ "Title: " + this.title + "\n"
				+ "Category: " + this.category+ "\n"
				+ "Minimium Age: " + this.minimiumAge + "\n"
				+ "Rating: " + this.getRating() + "\n"
				+ "----------------------------------\n";
	}
}
