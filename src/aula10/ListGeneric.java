package aula10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListGeneric<T> implements Iterator<T>, Iterable<T>
{
	List<T> list;
	private int index;
	
	public ListGeneric()
	{
		this.list = new LinkedList<T>();
		this.index = 0;
	}
	
	public boolean addElem(T elem)
	{
		return list.add(elem);
	}
	
	public boolean removeElem(T elem)
	{
		return list.remove(elem);
	}
	
	public int totalElem()
	{
		return list.size();
	}

	public boolean hasNext() 
	{
		return (index < list.size());
	}

	@Override
	public T next() 
	{
		if(index < list.size())
		{			
			return list.get(index++);
		}
		return null;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return list.iterator();
	}
	
}
