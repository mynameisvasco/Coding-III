package aula7;

public class Hour implements Comparable<Hour>
{
	private int hour;
	private int minute;
	
	public Hour(int hour, int minute)
	{
		this.hour = hour;
		this.minute = minute;
	}
	
	public Hour(String h)
	{	
		this.hour = Integer.parseInt(h.split(":")[0]);
		this.minute = Integer.parseInt(h.split(":")[1]);
	}
	
	public String toString()
	{
		if(this.hour < 10)
		{
			if(this.minute < 10)
			{
				return "0" + this.hour + ":" + "0" + this.minute;
			}
			else
			{				
				return "0" + this.hour + ":" + this.minute;
			}
		}
		return this.hour + ":" + this.minute;
	}

	public int getHour() 
	{
		return this.hour;
	}

	public int getMinute() 
	{
		return this.minute;
	}
	
	public void setMinute(int m)
	{
		this.minute = m;
	}
	
	public void setHour(int h)
	{
		this.hour = h;
	}
	
	public static Hour sumHours(Hour h1, Hour h2)
	{
		Hour sHour = new Hour(0, 0);
	
		int sumMin = h1.getMinute() + h2.getMinute();
		sHour.setHour(h1.getHour() + sumMin/60);
		sHour.setMinute(sumMin%60);
		
		return sHour;
	}
	
	public int compareTo(Hour h)
	{
		if(this.hour > h.getHour())
		{
			return 1;
		}
		else if(this.hour == h.getHour())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	

}
