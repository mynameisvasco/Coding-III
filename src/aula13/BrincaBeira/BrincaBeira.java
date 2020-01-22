package aula13.BrincaBeira;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class BrincaBeira 
{
	private List<String> employeesName;
	private HashMap<String, String> toysGifted;
	private Set<String> toysNames;
	private HashMap<String, Integer> employeesNameFreq;
	private LinkedList<String> footballTickets;
	private static int awardedEmployee = 0;
	
	public BrincaBeira()
	{
		employeesName = new ArrayList<String>();
		toysGifted = new HashMap<String, String>();
		toysNames = new HashSet<String>();
		employeesNameFreq = new HashMap<String, Integer>();
		footballTickets = new LinkedList<String>();
	}
	
	public void addWorker(String name)
	{
		this.employeesName.add(name);
		if(this.employeesNameFreq.get(name) != null)
		{
			this.employeesNameFreq.put(name, this.employeesNameFreq.get(name) + 1);
		}
		else
		{
			this.employeesNameFreq.put(name, 1);
		}
	}
	
	public void removeWorker(String name)
	{
		this.employeesName.remove(name);
		if(this.employeesNameFreq.get(name) != null)
		{
			this.employeesNameFreq.put(name, this.employeesNameFreq.get(name) - 1);
		}
		footballTickets.remove(name);
	}
	
	public void addToy(String name)
	{
		while(!this.toysNames.add(name + "#" + this.employeesName.get(new Random().nextInt(this.employeesName.size()))));
	}
	
	public void removeToy(String name)
	{
		this.toysNames.remove(name);
	}
	
	public void giftToy()
	{
		this.toysGifted.put(this.employeesName.get(new Random().nextInt(this.employeesName.size())),
				this.toysNames.iterator().next());
	}
	
	public void awardTicket()
	{
		this.footballTickets.add(this.employeesName.get(BrincaBeira.awardedEmployee));
		BrincaBeira.awardedEmployee++;
	}
	
	public List<String> getWorkers()
	{
		return this.employeesName;
	}
	
	public List<String> getToys()
	{
		return this.toysNames.stream().collect(Collectors.toList());
	}
	
	public HashMap<String, String> getGiftedToys()
	{
		return this.toysGifted;
	}
	
	public LinkedList<String> getAwardedTickets()
	{
		return this.footballTickets;
	}
}
