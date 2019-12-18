package aula12;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Scanner;

import aula5.Car;

public class ClassAnalyser 
{
	/**
	 * @param args
	 */
	static String[] primitiveTypes = new String[] {"int", "double", "float", "char", "boolean", "long"};
	static LinkedList<Type> primitiveToObject = new LinkedList<Type>();
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args)
	{
		primitiveToObject.add(Integer.class);
		primitiveToObject.add(Double.class);
		primitiveToObject.add(Float.class);
		primitiveToObject.add(Character.class);
		primitiveToObject.add(Boolean.class);
		primitiveToObject.add(Long.class);
		System.out.println("Class name: " + Car.class.getSimpleName());
		System.out.println("-----------------------");
		System.out.println("Class package: " + Car.class.getPackageName());
		System.out.println("-----------------------");
		System.out.println("Class interfaces");
		System.out.println("-----------------------");
		if(Car.class.getInterfaces().length == 0)
		{
			System.out.println("This class doesn't implement any interface");
		}
		else
		{
			for(Class<?> t : Car.class.getInterfaces())
			{			
				
				System.out.println(t);
			}
		}
		System.out.println("-----------------------");
		System.out.println("Super Class: " + Car.class.getSuperclass());
		System.out.println("-----------------------");
		System.out.println("Class constructors");
		for(Constructor<?> c : Car.class.getConstructors())
		{
			System.out.println(c);
		}
		System.out.println("-----------------------");
		System.out.println("Class methods");
		for(Method m : Car.class.getDeclaredMethods())
		{
			System.out.println(m);
		}
		System.out.println("Super Class constructors");
		for(Constructor<?> c : Car.class.getSuperclass().getConstructors())
		{
			System.out.println(c);
		}
		System.out.println("-----------------------");
		System.out.println("Super Class methods");
		for(Method m : Car.class.getDeclaredMethods())
		{
			System.out.println(m);
		}
	}
}
