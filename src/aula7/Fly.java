package aula7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class Fly 
{
	public Hour hour;
	public String name;
	public Company company;
	public String origin;
	public Hour delay;
	public String obs;
	
	public Fly(Hour hour, String name, Company company, String origin, Hour delay, String obs) 
	{
		this.hour = hour;
		this.name = name;
		this.company = company;
		this.origin = origin;
		this.delay = delay;
		this.obs = obs;
	}

	public String toString()
	{
		return this.hour 
				+ "\t" + this.name
				+ "\t" + this.company
				+ "\t" + this.origin
				+ "\t" + this.delay
				+ "\t " + this.obs + "\n";
	}
	
	public Hour getHour() 
	{
		return hour;
	}

	public String getName() 
	{
		return name;
	}

	public String getOrigin() 
	{
		return origin;
	}

	public Hour getDelay() 
	{
		return delay;
	}
	
	public static LinkedList<Fly> loadFromFile(String path, String pathCompany) throws IOException
	{
		//Process companies files to know which company names belongs to each initial
		LinkedList<Company> companies = Company.loadFromFile(pathCompany);
		
	    List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
	    lines.remove(0); // Remove table header
		LinkedList<Fly> flights = new LinkedList<Fly>();
		
		for(String line : lines)
		{
			String[] flyData = line.split("\t");
			
			//Convert fly company initials from fly name to company 
			Company c = Company.flyNameToCompany(companies, flyData[1]);
			
			// Some times flights have no delay so it is null, we need to be careful
			if(flyData.length == 4)
			{				
				//Calculate obs = hour + delay
				Hour obs = Hour.sumHours(new Hour(flyData[0]), new Hour(flyData[3]));
				String obsString = "Previsto: " + obs.toString();
				
				flights.add(new Fly(new Hour(flyData[0]), flyData[1], c, flyData[2], new Hour(flyData[3]), obsString));
			}
			else
			{
				flights.add(new Fly(new Hour(flyData[0]), flyData[1], c, flyData[2], new Hour("00:00"), ""));
			}
		}
		
		return flights;
	}
	
	public static void saveToFile(LinkedList<Fly> flights, String path) throws IOException
	{
		String header = "Hora \t Voo \t Companhia \t Origem \t Atraso \t Obs\n";
		Files.write(Paths.get(path), header.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
		
		for(Fly f : flights)
		{
			Files.write(Paths.get(path), f.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND );
		}
	}
	
	public static void saveCitiesToFile(LinkedList<Fly> flights, String path) throws IOException
	{
		String header = "Origem \t Nº de Voos \n";
		Files.write(Paths.get(path), header.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
		LinkedList<String> writtenOrigins = new LinkedList<String>();
		
		
		for(Fly f : flights)
		{
			int currentOriginFlyN = 0;
			
			for(Fly f2 : flights)
			{
				if(f.getOrigin().equals(f2.getOrigin()) && !writtenOrigins.contains(f.getOrigin()))
				{
					currentOriginFlyN++;
				}
			}
			
			if(!writtenOrigins.contains(f.getOrigin()))
			{
				writtenOrigins.add(f.getOrigin());
				String originString = f.getOrigin() + "\t" + currentOriginFlyN + "\n";
				Files.write(Paths.get(path), originString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND );
			}
		}
	}
}
