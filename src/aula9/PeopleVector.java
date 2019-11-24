package aula9;

import aula1.Person;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class PeopleVector 
{
	private Person[] people;
	private int size = 0;
	private VectorIterator iterator;
	
	public PeopleVector(int initialCapacity)
	{
		this.people = new Person[initialCapacity];
		this.iterator = new VectorIterator();
	}
	
	public PeopleVector()
	{
		this(5);
	}
	
	public boolean addPerson(Person p)
	{
		int oldCapacity = this.people.length;
		int minCapacity = this.size + 1;
		if(minCapacity > oldCapacity)
		{
			int newCapacity = oldCapacity + minCapacity;
			this.people = Arrays.copyOf(this.people, newCapacity);
		}
		this.people[size] = p;
		size++;
		return true;
	}
	
	public boolean removePerson(Person p)
	{
		for(int i = 0; i < this.size; i++)
		{
			if(this.people[i].equals(p))
			{
				this.people[i] = null;
				for(int k = i; k < this.size - 1; k++)
				{
					Person tmp = this.people[k + 1];
					this.people[k + 1] = this.people[k];
					this.people[k] = tmp;
				}
				return true;
			}
		}
		
		return false;
	}
	
	public int totalPeople()
	{
		return this.size;
	}
	
	public Iterator<Person> iterator()
	{
		return this.iterator;
	}
	
	class VectorIterator implements Iterator<Person>
	{
		int pointer = 0; 
		
		public boolean hasNext() 
		{
			
			return pointer < size;
		}

		public Person next() 
		{
			int i = pointer;
			if(i >= size)
			{
				throw new NoSuchElementException();
			}
			pointer = i + 1;
			return people[i];
		}
	}
}
