package aula12.plugins;
import aula12.IPlugin;

public class BinaryConverter implements IPlugin
{
	public String convert(String code)
	{
		try
		{
			Integer i = Integer.parseInt(code);
			return "Binary conversion -> " + Integer.toBinaryString(i);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Argument provided is not a number");
			System.exit(0);
			return null;
		}
	}
}
