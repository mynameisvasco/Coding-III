package aula2;

import java.util.LinkedList;

public class Database 
{
	public static LinkedList<Student> students;
	public static LinkedList<Worker> workers;
	public static LinkedList<Video> videos;
	public static int maxVideoQuota;
	
	public Database(int maxVideoQuota)
	{
		Database.students = new LinkedList<Student>();
		Database.workers = new LinkedList<Worker>();
		Database.videos = new LinkedList<Video>();
		Database.maxVideoQuota = maxVideoQuota;
	}
	
	public static Student searchStudent(int id)
	{
		for(int i = 0; i < Database.students.size(); i++)
		{
			if(Database.students.get(i).getNmec() == id)
			{
				return Database.students.get(i);
			}
		}
		
		return null;
	}
	
	public static Worker searchWorker(int id)
	{
		for(int i = 0; i < Database.workers.size(); i++)
		{
			if(Database.workers.get(i).getWorkerNum() == id)
			{
				return Database.workers.get(i);
			}
		}
		
		return null;
	}
	
	public static Video searchVideo(int id)
	{
		for(int i = 0; i < Database.videos.size(); i++)
		{
			if(Database.videos.get(i).getId() == id)
			{
				return Database.videos.get(i);
			}
		}
		
		return null;
	}
}
