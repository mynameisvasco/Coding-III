package aula6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListProcess 
{
	public static <T> List<T> filter(List<T> list, Predicate<T> cond)
	{
		List<T> filteredList = new ArrayList<>();
		for(T element : list)
		{
			if(cond.test(element))
			{
				filteredList.add(element);
			}
		}
		
		return filteredList;
	}
}
