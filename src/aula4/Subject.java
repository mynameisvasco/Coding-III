package aula4;

import aula3.Student;
import java.util.LinkedList;

public class Subject 
{
	private String name;
	private String area;
	private int ects;
	private Teacher responsible;
	private LinkedList<Student> students;
	
	public Subject(String name, String area, int ects, Teacher responsible)
	{
		this.name = name;
		this.area = area;
		this.ects = ects;
		this.responsible = responsible;
		students = new LinkedList<Student>();
	}
	
	public boolean addStudent(Student s)
	{
		return this.students.add(s);
	}
	
	public boolean delStudent(int nMec)
	{
		for(int i = 0; i < this.students.size(); i++)
		{
			if(this.students.get(i).getNmec() == nMec)
			{
				this.students.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkStudent(int nMec)
	{
		for(int i = 0; i < this.students.size(); i++)
		{
			if(this.students.get(i).getNmec() == nMec)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int getStudentsNum()
	{
		return this.students.size();
	}
	
	public LinkedList<Student> getStudents()
	{
		return this.students;
	}
	
	public LinkedList<Student> getStudents(String type)
	{
		LinkedList<Student> tmp = new LinkedList<Student>();
		
		for(int i = 0; i < this.students.size(); i++)
		{
			if(this.students.get(i).getClass().getSimpleName().equals(type))
			{
				tmp.add(this.students.get(i));
			}
		}
		
		return tmp;
	}
	
	public String toString()
	{
		return "Name: " + this.name + "\n"
				+ "Area: " + this.area + "\n"
				+ "ECTS: " + this.ects + "\n"
				+ "Responsible: "+ this.responsible.getName() + "\n";
	}
}
