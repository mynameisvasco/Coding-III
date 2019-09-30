package aula2;

import aula1.Date;
import aula1.Person;

public class Worker extends Person
{
	private int workerNum;
	private int fiscalNum;
	
	public Worker(String name, int cc, Date birth, int workerNum, int fiscalNum)
	{
		super(name, cc, birth);
		this.workerNum = workerNum;
		this.fiscalNum = fiscalNum;
	}
	
	public int getWorkerNum()
	{
		return this.workerNum;
	}
	
	public int getFiscalNum()
	{
		return this.fiscalNum;
	}
	
	public static Student createStudent(Student s)
	{
		Database.students.add(s);
		return s;
	}
	
	public static boolean deleteStudent(int nmec)
	{
		for(int i = 0; i < Database.students.size(); i++)
		{
			if(Database.students.get(i).getNmec() == nmec)
			{
				Database.students.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public static Worker createWorker(Worker w)
	{
		Database.workers.add(w);
		return w;
	}
	
	public static boolean deleteWorker(int id)
	{
		for(int i = 0; i < Database.workers.size(); i++)
		{
			if(Database.workers.get(i).getWorkerNum() == id)
			{
				Database.workers.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public static Video createVideo(Video v)
	{
		Database.videos.add(v);
		return v;
	}
	
	public static boolean deleteVideo(int id)
	{
		for(int i = 0; i < Database.videos.size(); i++)
		{
			if(Database.videos.get(i).getId() == id)
			{
				Database.videos.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public String toString()
	{
		return "----------------------------------\n"
				+ "Name: " + this.getName() + "\n"
				+ "CC: " + this.getCC()+ "\n"
				+ "Birth: " + this.getBirth().toString() + "\n"
				+ "Fiscal Number: " + this.fiscalNum + "\n"
				+ "Worker Number: " + this.workerNum+ "\n"
				+ "----------------------------------\n";
	}
	
}

