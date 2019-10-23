package aula5;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import aula1.Date;

public class PersonManager 
{
	static Scanner userInput;
	static LinkedList<Person> persons;
	
	public static void main(String args[]) throws IOException
	{
		userInput = new Scanner(System.in);
		persons = new LinkedList<Person>();
		int selection;
		do
		{
			System.out.println("> Person Manager <");
			System.out.println("[1] Add person");
			System.out.println("[2] Delete person");
			System.out.println("[3] Display people list");
			System.out.println("[4] Order people list by name");
			System.out.println("[5] Order people list by CC");
			System.out.println("[6] Load from file");
			System.out.println("[7] Save to file");
			System.out.println("[8] Exit");
			System.out.print("Option > ");
			selection = Integer.parseInt(userInput.nextLine());
			
			switch(selection)
			{
				case 1:
					addPerson();
					break;
				
				case 2:
					deletePerson();
					break;
					
				case 3:
					displayPeople();
					break;
				
				case 4:
					sortByName();
					break;
					
				case 5:
					sortByCC();
					break;
					
				case 6:
					loadFromFile();
					break;
				
				case 7:
					saveToFile();
					break;
					
				case 8:
					System.exit(0);
					break;
			}
		}
		while(selection != 8);
	}
	
	public static void addPerson()
	{
		
		System.out.println("> Add person <");
		System.out.print("Name -> ");
		String name = userInput.nextLine();
		
		System.out.print("CC -> ");
		int cc = Integer.parseInt(userInput.nextLine());
		
		System.out.print("Birth (DD/MM/YYYY) -> ");
		String date = userInput.nextLine();
		
		persons.add(new Person(name, cc, new Date(date)));
		
		System.out.println("Person added with success");
		
	}
	
	public static void deletePerson()
	{
		System.out.println("> Delete person <");
		System.out.print("CC -> ");
		int cc = Integer.parseInt(userInput.nextLine());
		boolean found = false;
		for(int i = 0; i < persons.size(); i++)
		{
			if(persons.get(i).getCC() == cc)
			{
				persons.remove(i);	
				found = true;
			}
		}
		
		if(found) System.out.println("Person removed with success");
		else System.out.println("Person not found");

	}
	
	public static void displayPeople()
	{
		System.out.println("> List of people <");
		
		for(int i = 0; i < persons.size(); i++)
		{
			
			System.out.println(persons.get(i).toString());
		}
	}
	
	public static void sortByName()
	{
		persons.sort(Comparator.comparing(Person::getName));
	}
	
	public static void sortByCC()
	{
		persons.sort(Comparator.comparing(Person::getCC));
	}
	
	public static void loadFromFile() throws IOException
	{
		System.out.print("File location -> ");
		String filePath = userInput.nextLine();
		Scanner fs = new Scanner(new File(filePath));
		String fileType = fs.nextLine();
		fs.close();
		
		Loadable ld = null;
		
		switch(fileType)
		{
			case "CSV":
				ld = new CSVLoader();
				break;
			
			case "Nokia":
				ld = new NokiaLoader();
				break;
			
			case "vCard":
				ld = new vCardLoader();
				break;
			
			default:
				System.out.println("Invalid format, try another file. (CSV, Nokia, vCard	");
				break;
		}
		
		System.out.println("File opened with success, we are importing your people");
		Person parsedPeople[] = ld.loadFile(new File(filePath));
		
		for(Person p : parsedPeople)
		{
			persons.add(p);
			System.out.println(p.getName() + " was imported with success");
		}
		
		System.out.println("People imported from file with success");
	}
	
	public static void saveToFile() throws IOException
	{
		System.out.print("File location -> ");
		String filePath = userInput.nextLine();
		System.out.print("File Type (CSV, Nokia, vCard) -> ");
		String fileType = userInput.nextLine();
		
		Loadable ld = null;
		
		switch(fileType)
		{
			case "CSV":
				ld = new CSVLoader();
				break;
			
			case "Nokia":
				ld = new NokiaLoader();
				break;
			
			case "vCard":
				ld = new vCardLoader();
				break;
			
			default:
				System.out.println("Invalid format, try another file. (CSV, Nokia, vCard	");
				break;
		}
		
		Person[] savedPeople = new Person[persons.size()];
		
		for(int i = 0; i < persons.size(); i++)
		{
			savedPeople[i] = persons.get(i);
		}
		
		ld.saveFile(savedPeople, filePath);
		
		System.out.println("People exported to file with success");
	}
}
