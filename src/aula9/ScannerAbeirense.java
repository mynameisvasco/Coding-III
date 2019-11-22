package aula9;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ScannerAbeirense implements Iterator<String>, Closeable
{
	
	private BufferedInputStream buffer;
	
	public ScannerAbeirense(File f) throws FileNotFoundException
	{
		this.buffer = new BufferedInputStream(new FileInputStream(f));
	}
	
	public ScannerAbeirense(InputStream input)
	{
		this.buffer = new BufferedInputStream(input);
	}

	public void close() throws IOException 
	{
		this.buffer.close();
	}

	public boolean hasNext() 
	{
		try 
		{
			if(this.buffer.read() == -1)
			{
				return false;
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public String next() 
	{
		try
		{
			int x = this.buffer.read();
			if(x != -1)
			{
				if((char) x == 'v') x = 'b';
				if((char) x == 'V') x = 'B';
				return "" + (char) x;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String nextLine()
	{
		String r = "";
		
		do
		{
			r += this.next();
		}
		while(this.next().equals("\n"));
		
		return r;
	}
	
}
