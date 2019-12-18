package aula12;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Scanner;

public class ObjectGenerator 
{
	static Scanner userInput = new Scanner(System.in);
	static HashMap<String, Class<?>> primitiveTypes = new HashMap<String, Class<?>>();
	
	public static void main(String[] args)
	{
		populatePrimitiveHashMap();
		
		Class<?> myClass = chooseClass();	
		
		Constructor<?> selectedConstructor = getConstructors(myClass);
		
		Object [] arguments = getParameters(selectedConstructor);
		
		Object o = createObject(arguments, selectedConstructor);
		System.out.println("Object created with success");
		System.out.println(o.toString());
		
	}
	
	public static Constructor<?> getConstructors(Class<?> choosenClass)
	{
		System.out.println("Please, choose a constructor");
		int i = 1;
		for(Constructor<?> c : choosenClass.getConstructors())
		{
			System.out.println("[" + i +"] " + c);
			i++;
		}
		System.out.print("Selection: ");
		int selection = Integer.parseInt(userInput.nextLine());
		
		Constructor<?> selectedConstructor = choosenClass.getConstructors()[selection - 1];
		
		return selectedConstructor;
	}
	
	public static Object[] getParameters(Constructor<?> selectedConstructor)
	{
		Object[] o = new Object[selectedConstructor.getParameterCount()];
		int i = 0;
		for(Parameter p : selectedConstructor.getParameters())
		{
			System.out.println("Provide values of the following argument: " + p.getName() + ", " + p.getType().getName());
			if(primitiveTypes.get(p.getType().getSimpleName()) != null)
			{
				Class<?> typeClass = primitiveTypes.get(p.getType().getSimpleName());
				o[i] = readValue(typeClass);
				i++;
				
			}
			else
			{
				Class<?> myClass = chooseClass(p.getType().getName());
				Constructor<?> myConstructor = getConstructors(myClass);
				Object[] myArguments = getParameters(myConstructor);
				o[i] = createObject(myArguments, myConstructor);
				i++;
			}
		}
		
		return o;
	}
	
	public static Class<?> chooseClass()
	{
		System.out.print("Please, choose a class: ");
		String className = userInput.nextLine();
		try 
		{
			return Class.forName(className);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Class not found, try again...");
			System.exit(0);
		}
		
		return null;
	}
	
	public static Class<?> chooseClass(String className)
	{
		try 
		{
			return Class.forName(className);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Class not found, try again...");
			System.exit(0);
		}
		
		return null;
	}
	
	public static Object readValue(Class<?> c)
	{
		String s = userInput.nextLine();
		switch(c.getSimpleName())
		{
			case "Integer":
				return Integer.parseInt(s);
			case "Double":
				return Double.parseDouble(s);
			case "Float":
				return Float.parseFloat(s);
			case "Long":
				return Double.parseDouble(s);
			case "Boolean":
				return Boolean.parseBoolean(s);
			case "Character":
				return Character.valueOf(s.charAt(0));
			default: //String
				return s;
		}
	}
	
	public static Object createObject(Object[] arguments, Constructor<?> constructor)
	{
		Object o = null;
		try 
		{
			o = constructor.newInstance(arguments);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		
		return o; 
	}
	
	public static void populatePrimitiveHashMap()
	{
		primitiveTypes.put("long", Long.class);
		primitiveTypes.put("int", Integer.class);
		primitiveTypes.put("double", Double.class);
		primitiveTypes.put("float", Float.class);
		primitiveTypes.put("boolean", Boolean.class);
		primitiveTypes.put("char", Character.class);
		primitiveTypes.put("String", String.class);	//Not primitive but it is a special case

	}
}
