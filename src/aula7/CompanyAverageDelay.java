package aula7;

public class CompanyAverageDelay implements Comparable<CompanyAverageDelay>
{
	private Company company;
	private int averageDelay;
	
	public CompanyAverageDelay(Company company, int averageDelay)
	{
		this.company = company;
		this.averageDelay = averageDelay;
	}
	
	public Company getCompany()
	{
		return company;
	}
	
	public int getAverageDelay()
	{
		return averageDelay;
	}
	
	public int compareTo(CompanyAverageDelay cad)
	{
		if(this.averageDelay > cad.getAverageDelay())
		{
			return 1;
		}
		else if(this.averageDelay < cad.getAverageDelay())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
