package aula5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import aula1.Date;

public class vCardLoader implements Loadable
{	
	public void saveFile(Person[] p, String path) throws IOException
	{
		File f = new File(path);
		if(!f.exists()) f.createNewFile();
		
		PrintWriter pw = new PrintWriter(new FileWriter(path), false);
		pw.println("vCard");
		for(Person person : p)
		{
			String s = "#" + person.getName() + "#" + person.getCC() + "#" + person.getBirth().toString();
			pw.println(s);
		}
		
		pw.close();
	}
	
	public Person[] loadFile(File f) throws FileNotFoundException
	{
		Scanner fs = new Scanner(f);
		int lineNum = -1; //Because first line represents the file type not a person to add
		while(fs.hasNextLine())
		{
			fs.nextLine();
			lineNum++;
		}
		fs.close();
		
		Person[] p = new Person[lineNum];
		
		fs = new Scanner(f);
		fs.nextLine(); //Skips file type line
		int i = 0;
		
		while(fs.hasNextLine())
		{
			String[] personData = fs.nextLine().split("#");	
			Person curPerson = new Person(personData[1], Integer.parseInt(personData[2]), new Date(personData[3]));
			p[i] = curPerson;
			i++;
		}
		fs.close();
		
		return p;
		
	}
}
