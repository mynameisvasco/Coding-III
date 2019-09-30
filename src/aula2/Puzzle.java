package aula2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle 
{
	private File file;
	private int size;
	private LinkedList<String> words;
	private LinkedList<String> result;
	private char[][] grid;
	
	public Puzzle(String file) throws FileNotFoundException
	{
		this.grid = new char[80][80]; //max size is 80x80
		this.words = new LinkedList<String>();
		this.result = new LinkedList<String>();
		this.file = new File(file);
		
		//Process rows
		Scanner fs = new Scanner(this.file);
		
		//Calculate puzzle size
		String firstLine = fs.nextLine();
		this.size = firstLine.length();
		
		int x = 0;
		for(int y = 0; y < this.size; y++)
		{
			grid[x][y] = firstLine.charAt(y);
		}	
		x++;
		
		while(fs.hasNextLine())
		{
			String currentLine = fs.nextLine();
			if(currentLine.contains(",")) 
			{
				for(String s : currentLine.split(", ")) 
				{
					words.add(s);
				}
			}
		}
		
	}
}
