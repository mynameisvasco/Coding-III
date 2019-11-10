package aula7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class Company 
{
	private String initials;
	private String name;
	
	public Company(String initials, String name) 
	{
		this.initials = initials;
		this.name = name;
	}

	public String getInitials() 
	{
		return this.initials;
	}

	public String getName() 
	{
		return this.name;
	}
	
	public String toString()
	{
		return this.name;
	}
	
	public boolean equals(Company c)
	{
		if (this.getName().equals(c.getName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static LinkedList<Company> loadFromFile(String path) throws IOException
	{
		List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
	    lines.remove(0); // Remove table header
		LinkedList<Company> companies = new LinkedList<Company>();
		
		for(String line : lines)
		{
			String[] companyData = line.split("\t");
			
			companies.add(new Company(companyData[0], companyData[1]));
		}
		
		return companies;
	}
	
	public static Company flyNameToCompany(LinkedList<Company> list, String flyName)
	{
		for(Company c : list)
		{
			if(flyName.contains(c.getInitials()))
			{
				return c;
			}
		}
		
		return new Company("-", "-");
	}
	
	public static CompanyAverageDelay averageDelayFromCompany(Company c, LinkedList<Fly> flights)
	{
		//In minutes
		int delay = 0;
		int amountOfFlights = 0;
		for(Fly f : flights)
		{
			if(f.company.equals(c))
			{
				delay += f.getDelay().getHour() * 60 + f.getDelay().getMinute();
				amountOfFlights++;
			}
		}
				
		return new CompanyAverageDelay(c, delay/amountOfFlights);
	}
	
	public static void avarageDelaySaveToFile(LinkedList<Company> companies, LinkedList<Fly> flights, String path) throws IOException
	{
		String header = "Companhia \t Atraso Médio (minutos) \n";
		Files.write(Paths.get(path), header.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
		
		LinkedList<CompanyAverageDelay> delays = new LinkedList<CompanyAverageDelay>();
		
		for(Company c : companies)
		{				
			delays.add(averageDelayFromCompany(c, flights));
		}
		
		delays.sort(CompanyAverageDelay::compareTo);
		
		for(int i = delays.size() - 1; i >= 0; i--)
		{
			String delayString = delays.get(i).getCompany() + "\t" + delays.get(i).getAverageDelay() + "\n";
			Files.write(Paths.get(path), delayString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		}
	}
}
