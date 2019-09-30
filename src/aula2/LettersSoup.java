package aula2;

import java.io.FileNotFoundException;

//INACABADO

public class LettersSoup 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Puzzle p = new Puzzle("puzzle.txt");
		
		System.out.println(p.toString());
	}
}
