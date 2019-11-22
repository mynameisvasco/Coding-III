package aula9;

import java.io.IOException;

public class TestScannerAbeirense 
{
	public static void main(String[] args) throws IOException
	{
		ScannerAbeirense sa = new ScannerAbeirense(System.in);
		System.out.print("Texto: ");
		String s = sa.nextLine();
		System.out.println(s);
		sa.close();
	}
}
