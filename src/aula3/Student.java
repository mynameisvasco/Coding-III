package aula3;

import aula1.Date;
import aula1.Person;

public class Student extends Person
{
	private static int nmecBase = 99;
	private int nmec;
	private String course;
	private Date signDate;
	
	public Student(String name, int cc, Date birth, String course, Date signDate)
	{
		super(name, cc, birth);
		this.nmec = Student.nmecBase++;
		this.course = course;
		this.signDate = signDate;
	}
	
	public Student(String name, int cc, Date birth, String course)
	{
		super(name, cc, birth);
		this.nmec = Student.nmecBase++;
		this.course = course;
		this.signDate = Date.today();
	}
	
	public String getCourse()
	{
		return this.course;
	}
	
	public int getNmec()
	{
		return this.nmec;
	}
	
	public Date getSignDate()
	{
		return this.signDate;
	}
	
	public String toString()
	{
		return "----------------------------------\n"
				+ "Name: " + this.getName() + "\n"
				+ "CC: " + this.getCC()+ "\n"
				+ "Birth: " + this.getBirth().toString() + "\n"
				+ "Course: " + this.getCourse() + "\n"
				+ "Nmec: " + this.getNmec()+ "\n"
				+ "Inscrição: " + this.getSignDate().toString() + "\n"
				+ "----------------------------------\n";
	}
	
	
}
