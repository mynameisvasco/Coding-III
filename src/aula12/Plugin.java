package aula12;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class PluginManager 
{
	@SuppressWarnings("deprecation")
	public static IPlugin load(String name) throws Exception 
	{
		Class<?> c = Class.forName(name);
		return (IPlugin) c.newInstance();
	}
}

public class Plugin 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.print("Enter a number: ");
		String number = userInput.nextLine();
		
		File proxyList = new File("src/aula12/plugins");
		ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
		for (String f: proxyList.list()) 
		{
			try 
			{
				plgs.add(PluginManager.load("aula12.plugins."+f.substring(0,f.lastIndexOf('.'))));
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		Iterator<IPlugin> it = plgs.iterator();
		while (it.hasNext()) 
		{
			System.out.println(it.next().convert(number));
		}
		
		userInput.close();
		
	}
}