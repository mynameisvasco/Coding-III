package aula2;

import java.util.LinkedList;

import aula1.Date;
import aula1.Person;

public class Student extends Person
{
	private int nmec;
	private String course;
	private LinkedList<Video> rented;
	private LinkedList<Video> rentHistory;
	private int videosNum;
	
	public Student(String name, int cc, Date birth, int nmec, String course)
	{
		super(name, cc, birth);
		this.nmec = nmec;
		this.course = course;
		this.rentHistory = new LinkedList<Video>();
		this.rented = new LinkedList<Video>();
	}
	
	public int getNmec()
	{
		return this.nmec;
	}
	
	public String getCourse()
	{
		return this.course;
	}
	
	public Video rentVideo(int id)
	{
		if(videosNum > Database.maxVideoQuota)
		{
			return null;
		}
		
		Video v = Database.searchVideo(id);
		
		if(v.getStatus().equals("In use"))
		{
			return null;
		}
			
		v.setStatus(1);
		v.setOwner(this.nmec);
		this.addHistory(v);
		this.addRented(v);
		this.videosNum++;
		return v;
	}
	
	public Video backVideo(int id, int rating)
	{
		Video v = Database.searchVideo(id);
		v.setStatus(0);
		v.setOwner(0);
		v.updateRating(rating);
		this.removeRented(id);
		this.videosNum--;
		return v;
	}
	
	public LinkedList<Video> getHistory()
	{
		return this.rentHistory;
	}
	
	public LinkedList<Video> getCurrentRentedVideos()
	{
		return this.rented;
	}
	
	public String getCurrentRentedVideosToString()
	{
		String s = "";
		for(int i = 0; i < this.rented.size(); i++) 
		{
			s += this.rented.get(i).toString();
		}
		return s;
	}
	
	public String toString()
	{
		return "----------------------------------\n"
				+ "Name: " + this.getName() + "\n"
				+ "CC: " + this.getCC()+ "\n"
				+ "Birth: " + this.getBirth().toString() + "\n"
				+ "Course: " + this.course + "\n"
				+ "Nmec: " + this.nmec+ "\n"
				+ "-- Rented Videos --\n"
				+ this.getCurrentRentedVideosToString()
				+ "----------------------------------\n";
	}
	
	private void addHistory(Video v)
	{
		this.rentHistory.add(v);
	}
	
	private void addRented(Video v)
	{
		this.rented.add(v);
	}
	
	private void removeRented(int id)
	{
		for(int i = 0; i < this.rented.size(); i++)
		{
			if(this.rented.get(i).getId() == id)
			{
				this.rented.remove(i);
			}
		}
	}
}
