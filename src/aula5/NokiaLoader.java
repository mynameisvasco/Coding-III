package aula5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import aula1.Date;

public class NokiaLoader implements Loadable
{	
	public void saveFile(Person[] p, String path) throws IOException
	{
		File f = new File(path);
		if(!f.exists()) f.createNewFile();
		
		PrintWriter pw = new PrintWriter(new FileWriter(path), false);
		
		pw.println("Nokia");
		
		for(Person person : p)
		{
			pw.println(person.getName());
			pw.println(person.getCC());
			pw.println(person.getBirth().toString());
			pw.println("\n");
		}
		
		pw.close();
	}
	
	public Person[] loadFile(File f) throws FileNotFoundException
	{
		Scanner fs = new Scanner(f);
		int lineNum = -1; //Because first line represents the file type not a person to add
		while(fs.hasNextLine())
		{
			if(!fs.nextLine().equals(" ")) lineNum++;
		}
		fs.close();
		
		Person[] p = new Person[lineNum/3];
		
		fs = new Scanner(f);
		fs.nextLine(); //Skips file format line
		int i = 0;
		
		while(fs.hasNextLine())
		{
			String name = fs.nextLine();
			int cc = Integer.parseInt(fs.nextLine());
			String date = fs.nextLine();
			if(fs.hasNextLine()) fs.nextLine(); //Consume white space line between contacts
			
			Person curPerson = new Person(name, cc, new Date(date));
			p[i] = curPerson;
			i++;
		}
		fs.close();
		
		return p;
		
	}
}
