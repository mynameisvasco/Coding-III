package aula9;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable
{
	
	private Scanner scanner;
	
	public ScannerAbeirense(File f) throws FileNotFoundException
	{
		this.scanner = new Scanner(f);
	}
	
	public ScannerAbeirense(InputStream input)
	{
		this.scanner = new Scanner(input);
	}

	public void close() throws IOException 
	{
		this.scanner.close();
	}

	public boolean hasNext() 
	{
		return this.scanner.hasNext();
	}

	public String next() 
	{
		return this.next().replaceAll("v", "b").replaceAll("V", "B");
	}
	
	public String nextLine()
	{
		return this.scanner.nextLine().replaceAll("v", "b").replaceAll("V", "B");
	}
	
}
