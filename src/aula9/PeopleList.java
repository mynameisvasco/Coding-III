package aula9;

import aula1.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PeopleList 
{
	private List<Person> list = new LinkedList<>();
	
	public boolean addPerson(Person p)
	{
		return list.add(p);
	}
	
	public boolean removePerson(Person p)
	{
		return list.remove(p);
	}
	
	public int size()
	{
		return list.size();
	}
	
	public Iterator<Person> iterator()
	{
		return list.iterator();
	}
}
