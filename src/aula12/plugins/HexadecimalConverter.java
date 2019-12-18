package aula12.plugins;

import aula12.IPlugin;

public class HexadecimalConverter implements IPlugin
{
	public String convert(String code)
	{
		try
		{
			Integer i = Integer.parseInt(code);
			return "Hexadecimal conversion -> " + Integer.toHexString(i).toUpperCase();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Argument provided is not a number");
			System.exit(0);
			return null;
		}
	}
}
