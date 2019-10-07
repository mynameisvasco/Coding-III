package aula3;
import aula1.Person;
import aula1.Date;

public class Driver extends Person
{
	private DrivingLicense license;
	
	public Driver(String name, int cc, Date birth, String[] drivingCategories, Date expireDate)
	{
		super(name, cc, birth);
		this.license = new DrivingLicense(drivingCategories, expireDate);
	}
	
	public DrivingLicense getLicense()
	{
		return this.license;
	}
	
	public String toString()
	{
		return "Name: " + this.getName() + "\n"
				+ "CC: " + this.getCC() + "\n"
				+ "Birth: " + this.getBirth().toString() + "\n"
				+ this.license.toString();
 	}
	
	public boolean canDrive(Vehicle v)
	{
		for(String s : this.license.getCategory())
		{
			if(s.equals(v.getLicenseCategory()))
			{
				return true;
			}
		}
		
		return false;
	}
}
