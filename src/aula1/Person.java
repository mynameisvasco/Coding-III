package aula1;

public class Person
{
	private String name;
	private int cc;
	private Date birth;
	
	
	public Person(String name, int cc, Date birth)
	{
		assert name.length() > 0 : "O nome é inválido";
		assert cc > 0 : "O CC é inválido";
		
		this.name = name;
		this.cc = cc;
		this.birth = birth;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCC()
	{
		return this.cc;
	}
	
	public Date getBirth()
	{
		return this.birth;
	}
	
	public String toString()
	{
				return "Name: " + this.getName() + "\n"
				+ "CC: " + this.getCC()+ "\n"
				+ "Birth: " + this.getBirth().toString() + "\n";
	}
}