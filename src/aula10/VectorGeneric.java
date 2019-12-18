package aula10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T>
{
	private T[] elements;
	private int size = 0;
	private VectorIterator iterator;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric(int initialCapacity)
	{
		this.elements = (T[]) new Object[initialCapacity];
		this.iterator = new VectorIterator();
	}
	
	public VectorGeneric()
	{
		this(5);
	}
	
	public boolean addPerson(T p)
	{
		int oldCapacity = this.elements.length;
		int minCapacity = this.size + 1;
		if(minCapacity > oldCapacity)
		{
			int newCapacity = oldCapacity + minCapacity;
			this.elements = Arrays.copyOf(this.elements, newCapacity);
		}
		this.elements[size] = p;
		size++;
		return true;
	}
	
	public boolean removePerson(T p)
	{
		for(int i = 0; i < this.size; i++)
		{
			if(this.elements[i].equals(p))
			{
				this.elements[i] = null;
				for(int k = i; k < this.size - 1; k++)
				{
					T tmp = this.elements[k + 1];
					this.elements[k + 1] = this.elements[k];
					this.elements[k] = tmp;
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
	
	public Iterator<T> iterator()
	{
		return this.iterator;
	}
	
	class VectorIterator implements Iterator<T>
	{
		int pointer = 0; 
		
		public boolean hasNext() 
		{
			
			return pointer < size;
		}

		public T next() 
		{
			int i = pointer;
			if(i >= size)
			{
				throw new NoSuchElementException();
			}
			pointer = i + 1;
			return elements[i];
		}
	}
}
