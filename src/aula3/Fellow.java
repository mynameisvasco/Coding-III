package aula3;

import aula1.Date;

public class Fellow extends Student
{

	private double fellowshipVal = 0;
	private Date fellowshipStart;
	private Date fellowshipEnd;
	
	public Fellow(String name, int cc, Date birth, String course, Date fellowshipStart, Date fellowshipEnd) 
	{
		super(name, cc, birth, course);
		this.fellowshipStart = fellowshipStart;
		this.fellowshipEnd = fellowshipEnd;
	}
	
	public Fellow(String name, int cc, Date birth, String course, Date fellowshipEnd) 
	{
		super(name, cc, birth, course);
		this.fellowshipStart = Date.today();
		this.fellowshipEnd = fellowshipEnd;
	}
	
	public void setFellowship(double v)
	{
		this.fellowshipVal = v;
	}
	
	public double getFellowship()
	{
		return this.fellowshipVal;
	}
	
	public Date getFellowshipStart()
	{
		return this.fellowshipStart;
	}
	
	public Date getFellowshipEnd()
	{
		return this.fellowshipEnd;
	}
	
	@Override 
	public String toString()
	{
		return "----------------------------------\n"
				+ "Name: " + this.getName() + "\n"
				+ "CC: " + this.getCC()+ "\n"
				+ "Birth: " + this.getBirth().toString() + "\n"
				+ "Course: " + this.getCourse() + "\n"
				+ "Nmec: " + this.getNmec()+ "\n"
				+ "Inscrição: " + this.getSignDate().toString() + "\n"
				+ "Valor da bolsa: " + this.getFellowship() + "\n"
				+ "Início da bolsa: " + this.getFellowshipStart() + "\n"
				+ "Fim da bolsa: " + this.getFellowshipEnd() + "\n"
				+ "----------------------------------\n";
	}
	
}
