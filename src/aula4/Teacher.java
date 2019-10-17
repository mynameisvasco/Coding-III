package aula4;

import aula1.Person;
import aula1.Date;

public class Teacher extends Person
{
	private static int numberBase = 100;
	private int number;
	private Date admissionDate;
	
	public Teacher(String name, int cc, Date birth)
	{
		super(name, cc, birth);
		this.number = Teacher.numberBase++;
		this.admissionDate = Date.today();
	}
	
	public Teacher(String name, int cc, Date birth, Date admissionDate)
	{
		super(name, cc, birth);
		this.number = Teacher.numberBase++;
		this.admissionDate = admissionDate;
	}

	public Teacher(String name, int cc, Date birth, int number, Date admissionDate)
	{
		super(name, cc, birth);
		this.number = number;
		this.admissionDate = admissionDate;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public Date getAdmissionDate()
	{
		return this.admissionDate;
	}
	
	public String toString()
	{
		return super.toString() + "\n"
				+ "Number: " + this.number +"\n"
				+ "Admission Date: " + this.admissionDate.toString() + "\n";
	}
}
