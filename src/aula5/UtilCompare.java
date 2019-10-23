package aula5;

import java.util.Arrays;

public class UtilCompare 
{
	public static Figure findMax(Figure[] f)
	{
		int maxIndex = 0;
		double maxArea = 0;
		for(int i = 0; i < f.length; i++) 
		{
			if(f[i].getArea() > maxArea)
			{
				maxArea = f[i].getArea();
				maxIndex = i;
			}
		}
		
		return f[maxIndex];
	}
	
	public static void sortArray(Figure[] f)
	{
		Arrays.sort(f);
	}
	
	public static void sortArray(Vehicle[] v)
	{
		Arrays.sort(v);
	}
}
